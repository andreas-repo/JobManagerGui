package org.printassist.jobmanagergui.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {
	// Date associated with this pane
	private LocalDate date;
	private static final Logger LOG = LogManager.getLogger(AnchorPaneNode.class);

	/**
	 * Create a anchor pane node. Date is not assigned in the constructor.
	 * @param children children of the anchor pane
	 */
	public AnchorPaneNode(Node... children) {
		super(children);
		// Add action handler for mouse clicked
		this.setOnMouseClicked(e -> System.out.println("This pane's date is: " + date));
	}

	public void addChild(Node... children) {
		this.getChildren().addAll(children);
		// Add action handler for mouse clicked
		this.setOnMouseClicked(e -> {
			System.out.println("This pane's date is: " + date);
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/printassist/jobmanagergui/popupDateWindow.fxml"));
				Parent root1 = fxmlLoader.load();
				Stage stage = new Stage();
				stage.setScene(new Scene(root1));
				stage.show();
				((Node) (e.getSource())).getScene().getWindow().hide();
			} catch (Exception ex) {
				LOG.info("Creating separate window for calendar failed! See stacktrace for infos: {}", ex, ex);
			}
		});

	}



	public AnchorPaneNode() {
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
