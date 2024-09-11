package org.printassist.jobmanagergui.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Job {

	public StringProperty firstName = new SimpleStringProperty();
	public StringProperty lastName = new SimpleStringProperty();
	public StringProperty emailAddress = new SimpleStringProperty();
	public StringProperty printerType = new SimpleStringProperty();
	public StringProperty phoneNumber = new SimpleStringProperty();
	public StringProperty address = new SimpleStringProperty();
	public StringProperty city = new SimpleStringProperty();
	public StringProperty province = new SimpleStringProperty();
	public StringProperty postalCode = new SimpleStringProperty();
	public StringProperty country = new SimpleStringProperty();
	public StringProperty date = new SimpleStringProperty();
	public StringProperty time = new SimpleStringProperty();

	public final String getFirstName() {
		return firstName.get();
	}

	public final StringProperty firstNameProperty() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public final String getLastName() {
		return lastName.get();
	}

	public final StringProperty lastNameProperty() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public final String getEmailAddress() {
		return emailAddress.get();
	}

	public final StringProperty emailAddressProperty() {
		return emailAddress;
	}

	public final void setEmailAddress(String emailAddress) {
		this.emailAddress.set(emailAddress);
	}

	public final String getPrinterType() {
		return printerType.get();
	}

	public final StringProperty printerTypeProperty() {
		return printerType;
	}

	public final void setPrinterType(String printerType) {
		this.printerType.set(printerType);
	}

	public final String getPhoneNumber() {
		return phoneNumber.get();
	}

	public final StringProperty phoneNumberProperty() {
		return phoneNumber;
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}

	public final String getAddress() {
		return address.get();
	}

	public final StringProperty addressProperty() {
		return address;
	}

	public final void setAddress(String address) {
		this.address.set(address);
	}

	public final String getCity() {
		return city.get();
	}

	public final StringProperty cityProperty() {
		return city;
	}

	public final void setCity(String city) {
		this.city.set(city);
	}

	public final String getProvince() {
		return province.get();
	}

	public final StringProperty provinceProperty() {
		return province;
	}

	public void setProvince(String province) {
		this.province.set(province);
	}

	public final String getPostalCode() {
		return postalCode.get();
	}

	public final StringProperty postalCodeProperty() {
		return postalCode;
	}

	public final void setPostalCode(String postalCode) {
		this.postalCode.set(postalCode);
	}

	public final String getCountry() {
		return country.get();
	}

	public final StringProperty countryProperty() {
		return country;
	}

	public final void setCountry(String country) {
		this.country.set(country);
	}

	public final String getDate() {
		return date.get();
	}

	public final StringProperty dateProperty() {
		return date;
	}

	public final void setDate(String date) {
		this.date.set(date);
	}

	public final String getTime() {
		return time.get();
	}

	public final StringProperty timeProperty() {
		return time;
	}

	public final void setTime(String time) {
		this.time.set(time);
	}
}
