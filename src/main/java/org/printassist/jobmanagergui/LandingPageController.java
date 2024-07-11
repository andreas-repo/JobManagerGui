package org.printassist.jobmanagergui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LandingPageController {

	@FXML
	private Label welcomeText;

	@FXML
	protected void onHelloButtonClick() {
		welcomeText.setText("Welcome to JavaFX Application!");
	}
}