package model;

import view.LoggingWindowView;
import view.MainWindow;
import controller.MainWindowController;
import database.LoggingOperations;
import entities.User;

public class LoggingWindowModel {

	private LoggingOperations loggingOperations;
	private LoggingWindowView view;

	public LoggingWindowModel(LoggingWindowView view) {
		this.view = view;
	}

	public void loginUser() {
		String login = this.view.getLoginTextField_1();
		String password = new String(this.view.getPasswordTextField_1());
		String rights = null;
		loggingOperations = new LoggingOperations();
		User user = null;
		if (login != null && password != null)
			user = loggingOperations.getUserByLoginAndPassword(login, password);
		if (user != null) {
			rights = user.getRights();
		}
		if (rights != null) {
			MainWindow mainWindow = new MainWindow(rights);
			MainWindowModel mainWindowModel = new MainWindowModel(mainWindow);
			MainWindowController mainWindowController = new MainWindowController(
					mainWindowModel, mainWindow);
			mainWindowController.control();
			mainWindow.setWelcomeTextLabel(login);
			mainWindow.setVisible(true);
			this.view.setVisible(false);
		} else
			this.view.setErrorLabel("Wrong login or password");

	}

}
