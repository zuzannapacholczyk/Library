package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.MainWindowModel;
import view.MainWindow;

public class MainWindowController {
	private MainWindow view;
	private MainWindowModel model;
	private ChangeListener tabActionListener;
	private ActionListener buttonActionListener;

	public MainWindowController(MainWindowModel model, MainWindow view) {
		this.model = model;
		this.view = view;
	}

	public void control() {
		tabActionListener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent changeEvent) {
				Component c = view.getTabbedPane().getSelectedComponent();
				c.setVisible(true);
			}
		};
		view.getTabbedPane().addChangeListener(tabActionListener);

		buttonActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.logOut();
			}
		};
		view.getLoggingButton().addActionListener(buttonActionListener);
	}
}
