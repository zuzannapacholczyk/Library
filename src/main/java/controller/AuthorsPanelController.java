package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AuthorsPanelView;
import model.AuthorsPanelModel;

public class AuthorsPanelController {

	private AuthorsPanelModel model;
	private AuthorsPanelView view;
	private ActionListener authorSearchListener;
	private ActionListener authorRemoveListener;
	private ActionListener authorAddListener;

	public AuthorsPanelController(AuthorsPanelModel model,
			AuthorsPanelView authorsView) {
		this.model = model;
		this.view = authorsView;
	}

	public void control() {
		authorSearchListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.searchForAuthor();

			}

		};
		view.getSearchButton().addActionListener(authorSearchListener);

		authorRemoveListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.removeAuthor();

			}

		};
		view.getRemoveButton().addActionListener(authorRemoveListener);
		
		authorAddListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.addAuthor();

			}

		};
		view.getAddButton().addActionListener(authorAddListener);
	}

}
