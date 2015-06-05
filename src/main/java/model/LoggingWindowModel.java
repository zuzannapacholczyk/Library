package model;

import view.MainWindow;
import database.LoggingOperations;
import entities.User;

public class LoggingWindowModel  {

	private LoggingOperations loggingOperations;
	MainWindow mainWindowView;
	public void checkLoginAndPassword(String login, String password) {
		loggingOperations = new LoggingOperations();
		User user = null;
		if(login != null && password != null)
			user = loggingOperations.getUserByLoginAndPassword(login, password);
		if (user != null) {
			System.out.println(user.getName());
			mainWindowView = new MainWindow();
			mainWindowView.setVisible(true);
		}
	}

}
