package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BooksPanelView;
import model.BooksPanelModel;

public class BooksPanelController {

	private BooksPanelModel model;
	private BooksPanelView view;
	private ActionListener addBookActionListener;
	private ActionListener addAuthorActionListener;
	private ActionListener removeBookActionListener;

	public BooksPanelController(BooksPanelModel model,
			BooksPanelView booksPanelView) {
		this.model = model;
		this.view = booksPanelView;
	}

	public void control() {
		addBookActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.addBook();
			}

		};
		view.getAddButton().addActionListener(addBookActionListener);

		removeBookActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.removeBook();
			}

		};
		view.getRemoveButton().addActionListener(removeBookActionListener);

		addAuthorActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.addAuthor();
			}

		};
		view.getAddAuthorButton().addActionListener(addAuthorActionListener);

	}

}
