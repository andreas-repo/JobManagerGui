package org.printassist.jobmanagergui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class JobManagementApplication extends Application {


	@Override
	public void start(Stage stage) throws IOException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("application_de", Locale.GERMAN);
		FXMLLoader fxmlLoader = new FXMLLoader(JobManagementApplication.class.getResource("landing-page-view.fxml"), resourceBundle);
		Scene scene = new Scene(fxmlLoader.load(), 800, 800);
		scene.getStylesheets().add("style.css");
		stage.setTitle("Welcome to the JobManagement Application!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}