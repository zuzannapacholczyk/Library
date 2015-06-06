package model;

import database.LoggingOperations;
import entities.User;
import view.ErrorDialog;
import view.UserAccountView;

public class UserAccountPanelModel {

	private UserAccountView view;

	public UserAccountPanelModel(UserAccountView userAccountView) {
		this.view = userAccountView;
		this.setListElements();
	}

	private void setListElements() {
		this.view.getListRights().addItem("a");
		this.view.getListRights().addItem("l");
		this.view.getListRights().addItem("r");
	}

	public void addUser() {
		User user = new User();
		user.setLogin(view.getLoginTextField());
		user.setName(view.getNameTextField());
		user.setSurname(view.getSurnameTextField());
		user.setPassword(new String(this.view.getPasswordTextField()));
		user.setRights(view.getChosenElement());

		LoggingOperations loggingOperations = new LoggingOperations();
		if(loggingOperations.addUser(user, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Uzytkownik dodany do bazy");
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Blad danych.");
		}
	}

	public void removeUser() {
		String login = view.getLoginTextField();
		String password = new String(view.getPasswordTextField());
		LoggingOperations loggingOperations = new LoggingOperations();
		if(loggingOperations.removeUser(login, password, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Uzytkownik poprawnie usuniety");
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Brak uzytkownika o podanych danych");
		}
	}

	public void updateUser() {
		User user = new User();
		user.setLogin(view.getLoginTextField());
		user.setName(view.getNameTextField());
		user.setSurname(view.getSurnameTextField());
		user.setPassword(new String(this.view.getPasswordTextField()));
		user.setRights(view.getChosenElement());
		LoggingOperations loggingOperations = new LoggingOperations();
		User foundUser = loggingOperations.getUserByLogin(user.getLogin(), view.getRights());
		if(foundUser == null) {
			ErrorDialog error = new ErrorDialog();
			error.showError("Brak uzytkownika o podanym loginie");
		}
		else {
			view.setNameTextField(foundUser.getName());
			view.setSurnameTextField(foundUser.getSurname());
			if(foundUser.getRights().equals("a")) {
				view.setChosenElement(0);
			}
			else if(foundUser.getRights().equals("l")) {
				view.setChosenElement(1);
			}
			else
				view.setChosenElement(2);
			view.getChangeButton().setText("Zatwierdz");
		}
		
	}
	
	public void changeUser() {
		User user = new User();
		user.setLogin(view.getLoginTextField());
		user.setName(view.getNameTextField());
		user.setSurname(view.getSurnameTextField());
		user.setPassword(new String(this.view.getPasswordTextField()));
		user.setRights(view.getChosenElement());
		LoggingOperations loggingOperations = new LoggingOperations();
		if(loggingOperations.updateUser(user, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Poprawnie zmieniono dane uzytkownika");
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Blad podczas wprowadzania zmian.");
		}
		view.getChangeButton().setText("Zmien");
	}

	public void clearFormular() {
		view.setLoginTextField("");
		view.setPasswordTextField("");
		view.setNameTextField("");
		view.setSurnameTextField("");
		view.setChosenElement(0);
	}

}
