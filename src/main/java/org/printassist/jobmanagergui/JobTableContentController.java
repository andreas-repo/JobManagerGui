package org.printassist.jobmanagergui;

import java.util.ArrayList;
import java.util.List;

import org.printassist.jobmanagergui.services.JobServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
	private VBox jobTableContentVBox;

	private ObservableList<Job> data;

	JobServiceImpl jobService = new JobServiceImpl();

	public void initialize() {
		data = FXCollections.observableArrayList();

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
		printerTypeColumn.setCellValueFactory(new PropertyValueFactory<>("printerType"));
		phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		data.addAll(fillWithDatabaseData());
		jobTableContentTableView.setItems(data);
	}

	private List<Job> fillWithMockData() {
		List<Job> list = new ArrayList<>();
		Job jobOne = new Job();
		jobOne.setFirstName("Andreas");
		jobOne.setLastName("Mayer");
		jobOne.setEmailAddress("andreas.m4020@gmail.com");
		jobOne.setPrinterType("WC 6655");
		jobOne.setPhoneNumber("0660-1234567890");
		list.add(jobOne);
		Job jobTwo = new Job();
		jobTwo.setFirstName("Ulrike");
		jobTwo.setLastName("Mayer");
		jobTwo.setEmailAddress("office.ukaltenhuber@gmx.at");
		jobTwo.setPrinterType("WC 6655");
		jobTwo.setPhoneNumber("0664-1234567890");
		list.add(jobTwo);

		return list;
	}

	@FXML
	protected void onAddJobButtonClick() {
		Job newJob = new Job();
		newJob.setFirstName(firstNameTextField.getText());
		newJob.setLastName(lastNameTextField.getText());
		newJob.setEmailAddress(emailAddressTextField.getText());
		newJob.setPrinterType(printerTypeTextField.getText());
		newJob.setPhoneNumber(phoneNumberTextField.getText());
		RestTemplate restTemplate = jobService.restTemplate(new RestTemplateBuilder());
		boolean result = jobService.createJob(newJob, restTemplate);
		initialize();
	}

	private List<Job> fillWithDatabaseData() {
		List<Job> list = new ArrayList<>();
		RestTemplate restTemplate = jobService.restTemplate(new RestTemplateBuilder());
		list.addAll(jobService.getAllJobs(restTemplate));
		return list;
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
