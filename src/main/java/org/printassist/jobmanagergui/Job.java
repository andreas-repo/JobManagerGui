package org.printassist.jobmanagergui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.SimpleTimeZone;

import javafx.beans.property.SimpleStringProperty;

public class Job {

	public SimpleStringProperty firstName = new SimpleStringProperty();
	public  SimpleStringProperty lastName = new SimpleStringProperty();
	public  SimpleStringProperty emailAddress = new SimpleStringProperty();
	public  SimpleStringProperty printerType = new SimpleStringProperty();
	public  SimpleStringProperty phoneNumber = new SimpleStringProperty();
	public SimpleStringProperty address = new SimpleStringProperty();
	public SimpleStringProperty city = new SimpleStringProperty();
	public SimpleStringProperty province = new SimpleStringProperty();
	public SimpleStringProperty postalCode = new SimpleStringProperty();
	public SimpleStringProperty country = new SimpleStringProperty();


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

	public String getAddress() {
		return address.get();
	}

	public SimpleStringProperty addressProperty() {
		return address;
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public String getCity() {
		return city.get();
	}

	public SimpleStringProperty cityProperty() {
		return city;
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public String getProvince() {
		return province.get();
	}

	public SimpleStringProperty provinceProperty() {
		return province;
	}

	public void setProvince(String province) {
		this.province.set(province);
	}

	public String getPostalCode() {
		return postalCode.get();
	}

	public SimpleStringProperty postalCodeProperty() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode.set(postalCode);
	}

	public String getCountry() {
		return country.get();
	}

	public SimpleStringProperty countryProperty() {
		return country;
	}

	public void setCountry(String country) {
		this.country.set(country);
	}
}
