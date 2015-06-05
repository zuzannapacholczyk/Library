package model;

import controller.LoggingWindowController;
import view.LoggingWindowView;
import view.MainWindow;

public class MainWindowModel {
	private MainWindow view;

	public MainWindowModel(MainWindow view) {
		this.view = view;
	}
	
	public void logOut() {
		this.view.setVisible(false);
		LoggingWindowView loggingWindowView = new LoggingWindowView();
		loggingWindowView.setVisible(true);
		LoggingWindowModel loggingWindowModel = new LoggingWindowModel(loggingWindowView);
		LoggingWindowController loggingWindowController = new LoggingWindowController(loggingWindowModel, loggingWindowView);
		loggingWindowController.contolButton();		
	}
}
