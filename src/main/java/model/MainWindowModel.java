package model;

import javax.swing.table.DefaultTableModel;

import controller.LoggingWindowController;
import entities.Author;
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
	
	public void addAuthorToBookPanel(int row) {
		Author author = new Author();
		author.setId(Integer.parseInt((String) view
				.getAuthorsPanel()
				.getResultTable()
				.getValueAt(
						row, 0)));
		author.setName((String) view
				.getAuthorsPanel()
				.getResultTable()
				.getValueAt(
						row, 1));
		author.setSurname((String) view
				.getAuthorsPanel()
				.getResultTable()
				.getValueAt(
						row, 2));
		view.getTabbedPane().setSelectedIndex(5);
		DefaultTableModel model = (DefaultTableModel) view
				.getBooksPanel().getAuthorResultTable()
				.getModel();
		model.addRow(author.changeIntoList().toArray());
	}
}
