package org.printassist.jobmanagergui.services;

import org.printassist.jobmanagergui.services.models.Invoice;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class InvoiceServiceImpl {
    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private static final String PAYMENT_METHOD = "Kontoinhaber: Andreas Mayer\n" + "IBAN: AT23 1500 0007 8119 1622\n" + "BIC: OBKLAT2L\n" + "Bank: Oberbank";

    public Invoice buildInvoice(String firstNameCustomer, String lastNameCustomer, String emailAddressCustomer, String phoneNumberCustomer, String printerTypeCustomer, String dateOfServiceRenderet, String startTimeOfService, String endTimeOfService, String notes) {
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

        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        restTemplate.postForObject("http://localhost:8080/createInvoice", invoice, Invoice.class);

        return invoice;
    }
}
