module org.printassist.jobmanagergui {
	requires javafx.controls;
	requires javafx.fxml;

	requires com.dlsc.formsfx;
	requires validatorfx;
	requires jakarta.ws.rs;
	requires resteasy.client.api;

	opens org.printassist.jobmanagergui to javafx.fxml;
	exports org.printassist.jobmanagergui;
}