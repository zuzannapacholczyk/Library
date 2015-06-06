package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.MainWindowModel;
import view.MainWindow;

public class MainWindowController {
	private MainWindow view;
	private MainWindowModel model;
	private ChangeListener tabActionListener;
	private ActionListener buttonActionListener;
	private ActionListener addAuthorButtonListener;

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

		addAuthorButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getTabbedPane().setSelectedIndex(4);
			}
		};
		view.getBooksPanel().getAddAuthorButton()
				.addActionListener(addAuthorButtonListener);
		
		view.getAuthorsPanel().getResultTable().addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		        	model.addAuthorToBookPanel(row);
		        }
		    }
		});
	}
}
