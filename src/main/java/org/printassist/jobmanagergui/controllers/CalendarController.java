package org.printassist.jobmanagergui.controllers;

import java.time.YearMonth;
import org.printassist.jobmanagergui.views.FullCalendarView;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class CalendarController {

	// Get the pane to put the calendar on
	@FXML
	public Pane calendarPane;
	@FXML
	public AnchorPane anchorPaneCalendar;

	public void initialize() {
		calendarPane.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
	}

}
