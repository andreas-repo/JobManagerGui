package org.printassist.jobmanagergui.controllers;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.printassist.jobmanagergui.models.Job;
import org.printassist.jobmanagergui.services.JobServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

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
	public Label addJobLabel;
	@FXML
	public HBox addJobHBox;
	@FXML
	public Label firstNameLabel;
	@FXML
	public TextField firstNameTextField;
	@FXML
	public TextField lastNameTextField;
	@FXML
	public Label lastNameLabel;
	@FXML
	public Label emailAddressLabel;
	@FXML
	public TextField emailAddressTextField;
	@FXML
	public Label phoneNumberLabel;
	@FXML
	public TextField phoneNumberTextField;
	@FXML
	public Label printerTypeLabel;
	@FXML
	public TextField printerTypeTextField;
	@FXML
	public Button addJobButton;
	@FXML
	public VBox jobTableControlsVBox;
	@FXML
	public HBox deleteJobHBox;
	@FXML
	public Label deleteJobLabel;
	@FXML
	public TextField deleteJobTextField;
	@FXML
	public Button deleteJobButton;
	@FXML
	public StackPane jobTableContentStackPane;
	@FXML
	public Label addressLabel;
	@FXML
	public TextField addressTextField;
	@FXML
	public Label cityLabel;
	@FXML
	public TextField cityTextField;
	@FXML
	public Label countryLabel;
	@FXML
	public TextField countryTextField;
	@FXML
	public Label postalCodeLabel;
	@FXML
	public TextField postalCodeTextField;
	@FXML
	public Label provinceLabel;
	@FXML
	public TextField provinceTextField;
	@FXML
	public Label timeLabel;
	@FXML
	public TextField timeTextField;
	@FXML
	public Label dateLabel;
	@FXML
	public DatePicker datePicker;
	@FXML
	public Label completedLabel;
	@FXML
	public TextField completedTextField;
	@FXML
	public GridPane addJobGridPane;
	@FXML
	private VBox jobTableContentVBox;

	JobServiceImpl jobService = new JobServiceImpl();

	public void initialize() {
		ObservableList<Job> data = FXCollections.observableArrayList();
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
		printerTypeColumn.setCellValueFactory(new PropertyValueFactory<>("printerType"));
		phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		data.addAll(fillWithDatabaseData());
		jobTableContentTableView.getItems().setAll(data);
		sizeTableColumnsToFillTable();
	}

	private void sizeTableColumnsToFillTable() {
		firstNameColumn.prefWidthProperty().bind(jobTableContentTableView.widthProperty().divide(5));
		lastNameColumn.prefWidthProperty().bind(jobTableContentTableView.widthProperty().divide(5));
		emailAddressColumn.prefWidthProperty().bind(jobTableContentTableView.widthProperty().divide(5));
		printerTypeColumn.prefWidthProperty().bind(jobTableContentTableView.widthProperty().divide(5));
		phoneNumberColumn.prefWidthProperty().bind(jobTableContentTableView.widthProperty().divide(5));

	}

	@FXML
	public void onDeleteJobButtonClick() {
		RestTemplate restTemplate = jobService.restTemplate(new RestTemplateBuilder());
		jobService.deleteJobThroughEmailAddress(deleteJobTextField.getText(), restTemplate);
		initialize();
		deleteJobTextField.setText(null);
	}

	@FXML
	protected void onAddJobButtonClick() {
		Optional<Job> result = jobService.findJobByEmailAddress(emailAddressTextField.getText(), jobService.restTemplate(new RestTemplateBuilder()));
		if (result.isEmpty()) {
			Job newJob = new Job();
			newJob.setFirstName(firstNameTextField.getText().isEmpty() ? "" : firstNameTextField.getText());
			newJob.setLastName(lastNameTextField.getText().isEmpty() ? "" : lastNameTextField.getText());
			newJob.setEmailAddress(emailAddressTextField.getText().isEmpty() ? "" : emailAddressTextField.getText());
			newJob.setPrinterType(printerTypeTextField.getText().isEmpty() ? "" : printerTypeTextField.getText());
			newJob.setPhoneNumber(phoneNumberTextField.getText().isEmpty() ? "" : phoneNumberTextField.getText());
			newJob.setAddress(addressTextField.getText().isEmpty() ? "" : addressTextField.getText());
			newJob.setCity(cityTextField.getText().isEmpty() ? "" : cityTextField.getText());
			newJob.setCountry(countryTextField.getText().isEmpty() ? "" : countryTextField.getText());
			newJob.setPostalCode(postalCodeTextField.getText().isEmpty() ? "" : postalCodeTextField.getText());
			newJob.setProvince(provinceTextField.getText().isEmpty() ? "" : provinceTextField.getText());
			newJob.setTime(timeTextField.getText().isEmpty() ? "" : timeTextField.getText());
			try {
				newJob.setDate(datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			} catch (NullPointerException e) {
				newJob.setDate("");
			}
			RestTemplate restTemplate = jobService.restTemplate(new RestTemplateBuilder());
			jobService.createJob(newJob, restTemplate);
		}

		initialize();
		cleanAddJobInputs();
	}

	private void cleanAddJobInputs() {
		firstNameTextField.setText(null);
		lastNameTextField.setText(null);
		emailAddressTextField.setText(null);
		printerTypeTextField.setText(null);
		phoneNumberTextField.setText(null);
	}

	private List<Job> fillWithDatabaseData() {
		RestTemplate restTemplate = jobService.restTemplate(new RestTemplateBuilder());
		return new ArrayList<>(jobService.getAllJobs(restTemplate));
	}

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
