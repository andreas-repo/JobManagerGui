package org.printassist.jobmanagergui;

import javafx.beans.property.SimpleStringProperty;

public class Job {

	public SimpleStringProperty firstName = new SimpleStringProperty();
	public  SimpleStringProperty lastName = new SimpleStringProperty();
	public  SimpleStringProperty emailAddress = new SimpleStringProperty();
	public  SimpleStringProperty printerType = new SimpleStringProperty();
	public  SimpleStringProperty phoneNumber = new SimpleStringProperty();

	public String getFirstName() {
		return firstName.get();
	}

	public SimpleStringProperty firstNameProperty() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public SimpleStringProperty lastNameProperty() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public String getEmailAddress() {
		return emailAddress.get();
	}

	public SimpleStringProperty emailAddressProperty() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress.set(emailAddress);
	}

	public String getPrinterType() {
		return printerType.get();
	}

	public SimpleStringProperty printerTypeProperty() {
		return printerType;
	}

	public void setPrinterType(String printerType) {
		this.printerType.set(printerType);
	}

	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	public SimpleStringProperty phoneNumberProperty() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}
}
