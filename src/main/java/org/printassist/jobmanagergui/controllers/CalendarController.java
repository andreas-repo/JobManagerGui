package org.printassist.jobmanagergui.controllers;

import java.time.YearMonth;

import org.printassist.jobmanagergui.models.Job;
import org.printassist.jobmanagergui.views.FullCalendarView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class CalendarController {

	// Get the pane to put the calendar on
	@FXML
	public Pane calendarPane;

	public void initialize() {
		calendarPane.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
	}

}
