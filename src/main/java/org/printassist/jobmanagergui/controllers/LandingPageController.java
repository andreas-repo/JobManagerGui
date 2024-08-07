package org.printassist.jobmanagergui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LandingPageController {
	@FXML
	public Tab jobTab;
	@FXML
	public TabPane jobTableContentTabPane;
	@FXML
	public StackPane jobTabInclude;
	@FXML
	public Tab finishTaskTab;
	@FXML
	public AnchorPane taskTabInclude;
}