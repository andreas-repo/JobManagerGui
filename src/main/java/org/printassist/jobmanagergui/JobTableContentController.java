package org.printassist.jobmanagergui;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class JobTableContentController {
	@FXML
	public TableView<Job> jobTableContentTableView;
	@FXML
	public TableColumn<Job, String> firstNameColumn;
	@FXML
	public TableColumn<Job, String> lastNameColumn;
	@FXML
	public TableColumn<Job, String> emailAddressColumn;
	@FXML
	public TableColumn<Job, String> printerTypeColumn;
	@FXML
	public TableColumn<Job, String> phoneNumberColumn;
	@FXML
	private VBox jobTableContentVBox;

	public TableView<Job> getJobTableContentTableView() {
		return jobTableContentTableView;
	}

	public void setJobTableContentTableView(TableView<Job> jobTableContentTableView) {
		this.jobTableContentTableView = jobTableContentTableView;
	}

	public TableColumn<Job, String> getFirstNameColumn() {
		return firstNameColumn;
	}

	public void setFirstNameColumn(TableColumn<Job, String> firstNameColumn) {
		this.firstNameColumn = firstNameColumn;
	}

	public TableColumn<Job, String> getLastNameColumn() {
		return lastNameColumn;
	}

	public void setLastNameColumn(TableColumn<Job, String> lastNameColumn) {
		this.lastNameColumn = lastNameColumn;
	}

	public TableColumn<Job, String> getEmailAddressColumn() {
		return emailAddressColumn;
	}

	public void setEmailAddressColumn(TableColumn<Job, String> emailAddressColumn) {
		this.emailAddressColumn = emailAddressColumn;
	}

	public TableColumn<Job, String> getPrinterTypeColumn() {
		return printerTypeColumn;
	}

	public void setPrinterTypeColumn(TableColumn<Job, String> printerTypeColumn) {
		this.printerTypeColumn = printerTypeColumn;
	}

	public TableColumn<Job, String> getPhoneNumberColumn() {
		return phoneNumberColumn;
	}

	public void setPhoneNumberColumn(TableColumn<Job, String> phoneNumberColumn) {
		this.phoneNumberColumn = phoneNumberColumn;
	}
}
