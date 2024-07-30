module org.printassist.jobmanagergui {
	requires javafx.controls;
	requires javafx.fxml;

	requires com.dlsc.formsfx;
	requires validatorfx;
	requires java.desktop;
	requires spring.web;
	requires spring.context;
	requires spring.boot;
    requires spring.beans;
    requires jakarta.annotation;
	requires org.apache.tomcat.embed.core;
    requires org.apache.commons.io;
    requires spring.core;
	requires jdk.jdi;

	opens org.printassist.jobmanagergui to javafx.fxml;
	exports org.printassist.jobmanagergui;
	exports org.printassist.jobmanagergui.services.models;
}