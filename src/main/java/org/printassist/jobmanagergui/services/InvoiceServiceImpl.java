package org.printassist.jobmanagergui.services;

import org.printassist.jobmanagergui.JobManagementApplication;
import org.printassist.jobmanagergui.services.models.Email;
import org.springframework.core.io.Resource;
import org.apache.commons.io.IOUtils;
import org.printassist.jobmanagergui.services.models.Invoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class InvoiceServiceImpl {
    @Value("classpath:/templates/invoiceTemplate.html")
    private Resource bodyPath;
    MailSenderServiceImpl mailSenderService;

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private static final String PAYMENT_METHOD = "Kontoinhaber: Andreas Mayer\n" + "IBAN: AT23 1500 0007 8119 1622\n" + "BIC: OBKLAT2L\n" + "Bank: Oberbank";

    public Invoice buildInvoice(String firstNameCustomer, String lastNameCustomer, String emailAddressCustomer, String phoneNumberCustomer, String printerTypeCustomer, String dateOfServiceRenderet, String startTimeOfService, String endTimeOfService, String notes, String duration) {
        Invoice invoice = new Invoice();
        invoice.setFirstNameCustomer(firstNameCustomer);
        invoice.setLastNameCustomer(lastNameCustomer);
        invoice.setEmailAddressCustomer(emailAddressCustomer);
        invoice.setPhoneNumberCustomer(phoneNumberCustomer);
        invoice.setPrinterTypeCustomer(printerTypeCustomer);
        invoice.setDateOfServiceRenderet(dateOfServiceRenderet);
        invoice.setStartTimeOfService(startTimeOfService);
        invoice.setEndTimeOfService(endTimeOfService);
        invoice.setNotes(notes);
        invoice.setPaymentMethod(PAYMENT_METHOD);
        invoice.setTotalCost(String.valueOf(50L * Long.parseLong(duration)));

        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        restTemplate.postForObject("http://localhost:8080/createInvoice", invoice, Invoice.class);

        return invoice;
    }

    public void sendInvoice(Invoice invoice, String receiver) throws IOException {
        mailSenderService = new MailSenderServiceImpl();
        Email email = new Email();
        email.setTo(receiver);
        email.setSubject("Rechnung für " + invoice.getFirstNameCustomer() + " " + invoice.getLastNameCustomer());
        email.setMessageBody(buildMessageBody(invoice));
        mailSenderService.sendEmail(email);
    }

    private String buildMessageBody(Invoice invoice) throws IOException {
        return new String((IOUtils.toByteArray(Objects.requireNonNull(JobManagementApplication.class.getClassLoader().getResourceAsStream("templates/invoiceTemplate.html")))), StandardCharsets.UTF_8)
                .replace("{{firstName}}", invoice.getFirstNameCustomer())
                .replace("{{lastName}}", invoice.getLastNameCustomer())
                .replace("{{emailAddress}}", invoice.getEmailAddressCustomer())
                .replace("{{phoneNumber}}", invoice.getPhoneNumberCustomer())
                .replace("{{printerType}}", invoice.getPrinterTypeCustomer())
                .replace("{{date}}", invoice.getDateOfServiceRenderet())
                .replace("{{startTime}}", invoice.getStartTimeOfService())
                .replace("{{endTime}}", invoice.getEndTimeOfService())
                .replace("{{invoiceDetails}}", invoice.getNotes())
                .replace("{{total}}", invoice.getTotalCost());
    }
}
