package start;

import model.LoggingWindowModel;
import controller.LoggingWindowController;
import view.LoggingWindowView;

public class StartLibrary {

	public static void main(String[] args) {
		openLoggingWindow();
	}

	private static void openLoggingWindow() {
		LoggingWindowView loggingWindowView = new LoggingWindowView();
		loggingWindowView.setVisible(true);
		LoggingWindowModel loggingWindowModel = new LoggingWindowModel(loggingWindowView);
		LoggingWindowController loggingWindowController = new LoggingWindowController(loggingWindowModel, loggingWindowView);
		loggingWindowController.contolButton();
	}
}
