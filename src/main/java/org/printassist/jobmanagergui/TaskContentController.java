package org.printassist.jobmanagergui;

import java.util.List;
import java.util.Optional;

import org.printassist.jobmanagergui.services.JobServiceImpl;
import org.printassist.jobmanagergui.services.MailSenderServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TaskContentController {
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
	@FXML
	public Label taskPostalCodeLabel;
	@FXML
	public TextField taskPostalCodeTextField;
	@FXML
	public Label taskCountryLabel;
	@FXML
	public TextField taskCountryTextField;
	@FXML
	public Label taskPrinterTypeLabel;
	@FXML
	public TextField taskPrinterTypeTextField;
	@FXML
	public Label taskDateLabel;
	@FXML
	public TextField taskDateTextField;
	@FXML
	public Label taskTimeLabel;
	@FXML
	public TextField taskTimeTextField;
	@FXML
	public Label taskDatePickerLabel;
	@FXML
	public DatePicker taskDatePicker;
	@FXML
	public Label taskBeginTimeLabel;
	@FXML
	public TextField taskBeginTimeTextField;
	@FXML
	public Label taskEndTimeLabel;
	@FXML
	public TextField taskEndTimeTextField;
	@FXML
	public Label taskNotesLabel;

	JobServiceImpl jobService = new JobServiceImpl();

	@FXML
	public void onGetTaskButtonClick() {
		RestTemplate restTemplate = jobService.restTemplate(new RestTemplateBuilder());
		Optional<Job> job = jobService.findJobByEmailAddress(getTaskTextField.getText(), restTemplate);
		try {
			if (job.isPresent()) {
				taskFirstNameTextField.setText(job.get().getFirstName());
				taskLastNameTextField.setText(job.get().getLastName());
				taskEmailAddressTextField.setText(job.get().getEmailAddress());
				taskPhoneNumberTextField.setText(job.get().getPhoneNumber());
				taskAddressTextField.setText(job.get().getAddress());
				taskCityTextField.setText(job.get().getCity());
				taskProvinceTextField.setText(job.get().getProvince());
				taskPostalCodeTextField.setText(job.get().getPostalCode());
				taskCountryTextField.setText(CountryEnum.getCountry(job.get().getCountry()).toString());
				taskPrinterTypeTextField.setText(job.get().getPrinterType());
				taskDateTextField.setText(job.get().getDate());
				taskTimeTextField.setText(job.get().getTime());

				taskVBox.setVisible(true);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

	public void sendMail() {
		MailSenderServiceImpl.sendPlainTextMail("xerox6655@gmail.com",
			"andreas.m4020@gmail.com",
			"Test Email",
			List.of("Hello", "World"),
			true);
	}
}
