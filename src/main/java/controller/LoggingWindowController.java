package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LoggingWindowModel;
import view.LoggingWindowView;

public class LoggingWindowController {
	private LoggingWindowModel model;
	private LoggingWindowView view;
	private ActionListener actionListener;
	
	public LoggingWindowController(LoggingWindowModel model, LoggingWindowView view) {
		this.model = model;
		this.view = view;
	}
	
    public void contolButton(){        
        actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				loginUser();
				
			}
        };                
        view.getBtnZaloguj().addActionListener(actionListener);   
    }
    
	private void loginUser() {
		String login = view.getLoginTextField_1();
		String password = new String(view.getPasswordTextField_1());
		model.checkLoginAndPassword(login, password);
		
	}
}
