package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LoggingWindowModel;
import view.LoggingWindowView;

public class LoggingWindowController {
	private LoggingWindowModel model;
	public LoggingWindowView view;
	private ActionListener actionListener;
	
	public LoggingWindowController(LoggingWindowModel model, LoggingWindowView view) {
		this.model = model;
		this.view = view;
	}
	
    public void contolButton(){        
        actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.loginUser();
				
			}
        };                
        view.getBtnZaloguj().addActionListener(actionListener);   
    }
}
