module org.printassist.jobmanagergui {
	requires javafx.controls;
	requires javafx.fxml;

	requires com.dlsc.formsfx;
	requires validatorfx;
	requires java.desktop;
	requires spring.web;
	requires spring.context;
	requires spring.boot;

	opens org.printassist.jobmanagergui to javafx.fxml;
	exports org.printassist.jobmanagergui;
}