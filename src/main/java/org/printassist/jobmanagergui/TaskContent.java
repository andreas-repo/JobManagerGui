package org.printassist.jobmanagergui;

import java.util.Optional;

import org.printassist.jobmanagergui.services.JobServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TaskContent {
	@FXML
	public Label getTaskLabel;
	@FXML
	public TextField getTaskTextField;
	@FXML
	public VBox taskVBox;
	@FXML
	public Label taskFirstNameLabel;
	@FXML
	public TextField taskFirstNameTextField;
	@FXML
	public Label taskLastNameLabel;
	@FXML
	public TextField taskLastNameTextField;
	@FXML
	public Button getTaskButton;
	@FXML
	public Label taskEmailAddressLabel;
	@FXML
	public TextField taskEmailAddressTextField;
	@FXML
	public Label taskPhoneNumberLabel;
	@FXML
	public TextField taskPhoneNumberTextField;
	@FXML
	public Label taskAddressLabel;
	@FXML
	public TextField taskAddressTextField;
	@FXML
	public Label taskCityLabel;
	@FXML
	public TextField taskCityTextField;
	@FXML
	public Label taskProvinceLabel;
	@FXML
	public TextField taskProvinceTextField;

	JobServiceImpl jobService = new JobServiceImpl();

	@FXML
	public void onGetTaskButtonClick() {
		RestTemplate restTemplate = jobService.restTemplate(new RestTemplateBuilder());
		Optional<Job> job = jobService.findJobByEmailAddress(getTaskTextField.getText(), restTemplate);
		if (job.isPresent()) {
			taskFirstNameTextField.setText(job.get().getFirstName());
			taskLastNameTextField.setText(job.get().getLastName());
			taskEmailAddressTextField.setText(job.get().getEmailAddress());
			taskPhoneNumberTextField.setText(job.get().getPhoneNumber());
			taskAddressTextField.setText(job.get().getAddress());
			taskCityTextField.setText(job.get().getCity());
			taskProvinceTextField.setText(job.get().getProvince());

			taskVBox.setVisible(true);
		}
	}
}
