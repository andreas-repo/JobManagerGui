package org.printassist.jobmanagergui.services.models;

public class Invoice {
    private String firstNameCustomer;
    private String lastNameCustomer;
    private String emailAddressCustomer;
    private String phoneNumberCustomer;
    private String printerTypeCustomer;
    private String dateOfServiceRenderet;
    private String startTimeOfService;
    private String endTimeOfService;
    private String notes;
    private String totalCost;
    private String paymentMethod;
    private String invoiceNumber;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFirstNameCustomer() {
        return firstNameCustomer;
    }

    public void setFirstNameCustomer(String firstNameCustomer) {
        this.firstNameCustomer = firstNameCustomer;
    }

    public String getLastNameCustomer() {
        return lastNameCustomer;
    }

    public void setLastNameCustomer(String lastNameCustomer) {
        this.lastNameCustomer = lastNameCustomer;
    }

    public String getEmailAddressCustomer() {
        return emailAddressCustomer;
    }

    public void setEmailAddressCustomer(String emailAddressCustomer) {
        this.emailAddressCustomer = emailAddressCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public String getPrinterTypeCustomer() {
        return printerTypeCustomer;
    }

    public void setPrinterTypeCustomer(String printerTypeCustomer) {
        this.printerTypeCustomer = printerTypeCustomer;
    }

    public String getDateOfServiceRenderet() {
        return dateOfServiceRenderet;
    }

    public void setDateOfServiceRenderet(String dateOfServiceRenderet) {
        this.dateOfServiceRenderet = dateOfServiceRenderet;
    }

    public String getStartTimeOfService() {
        return startTimeOfService;
    }

    public void setStartTimeOfService(String startTimeOfService) {
        this.startTimeOfService = startTimeOfService;
    }

    public String getEndTimeOfService() {
        return endTimeOfService;
    }

    public void setEndTimeOfService(String endTimeOfService) {
        this.endTimeOfService = endTimeOfService;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
