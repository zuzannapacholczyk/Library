package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UserAccountView;
import model.UserAccountPanelModel;

public class UserAccountPanelController {

	private UserAccountPanelModel model;
	private UserAccountView view;
	private ActionListener addUserAction;
	private ActionListener removeUserAction;
	private ActionListener updateUserAction;

	public UserAccountPanelController(UserAccountPanelModel model,
			UserAccountView userAccountView) {
		this.model = model;
		this.view = userAccountView;
	}

	public void control() {
		addUserAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.addUser();

			}

		};
		view.getAddButton().addActionListener(addUserAction);
		
		removeUserAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.removeUser();

			}

		};
		view.getDeleteButton().addActionListener(removeUserAction);
		
		updateUserAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(view.getChangeButton().getText().equals("Zmien"))
					model.updateUser();
				else
					model.changeUser();

			}

		};
		view.getChangeButton().addActionListener(updateUserAction);

	}

}
