package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BorrowingPanelView;
import model.BorrowingPanelModel;

public class BorrowingPanelController {

	private BorrowingPanelModel model;
	private BorrowingPanelView view;
	private ActionListener borrowAction;
	private ActionListener getAction;

	public BorrowingPanelController(BorrowingPanelModel model,
			BorrowingPanelView borrowingPanelView) {
		this.model = model;
		this.view = borrowingPanelView;
	}

	public void control() {
		borrowAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.borrowBook();

			}
		};
		view.getBorrowBookButton().addActionListener(borrowAction);

		getAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.returnBook();

			}
		};
		view.getReturnBookButton().addActionListener(getAction);

	}

}
