package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ReaderPanelView;
import model.ReaderPanelModel;

public class ReaderPanelController {

	private ReaderPanelModel model;
	private ReaderPanelView view;
	private ActionListener addReaderAction;
	private ActionListener cleanAction;
	private ActionListener removeReaderAction;
	private ActionListener changeReaderAction;

	public ReaderPanelController(ReaderPanelModel model,
			ReaderPanelView readerPanelView) {
		this.model = model;
		this.view = readerPanelView;
	}

	public void control() {
		addReaderAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.addReader();

			}

		};
		view.getAddButton().addActionListener(addReaderAction);
		
		cleanAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.clearFormular();

			}

		};
		view.getClearButton().addActionListener(cleanAction);
		
		removeReaderAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.removeReader();

			}

		};
		view.getDeleteButton().addActionListener(removeReaderAction);
		
		changeReaderAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(view.getChangeButton().getText().equals("Zmien"))
					model.updateReader();
				else
					model.changeReader();

			}

		};
		view.getChangeButton().addActionListener(changeReaderAction);

	}

}
