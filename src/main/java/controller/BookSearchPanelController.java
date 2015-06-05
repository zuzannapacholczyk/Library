package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BookSearchPanelView;
import model.BookSearchPanelModel;

public class BookSearchPanelController {

	private BookSearchPanelModel model;
	private BookSearchPanelView view;
	private ActionListener searchButtonListener;

	public BookSearchPanelController(BookSearchPanelModel model,
			BookSearchPanelView bookSearchPanelView) {
		this.model = model;
		this.view = bookSearchPanelView;
	}

	public void control() {
		searchButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.searchForBook();

			}

		};
		view.getSearchButton().addActionListener(searchButtonListener);

	}


}
