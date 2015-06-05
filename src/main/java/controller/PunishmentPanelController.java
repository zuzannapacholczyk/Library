package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PunishmentView;
import model.PunishmentPanelModel;

public class PunishmentPanelController {

	private PunishmentPanelModel model;
	private PunishmentView view;
	private ActionListener findPunishmentAction;
	private ActionListener payForAllPunishmentsAction;

	public PunishmentPanelController(PunishmentPanelModel model,
			PunishmentView punishmentView) {
		this.model = model;
		this.view = punishmentView;
	}

	public void control() {
		findPunishmentAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.findPunishments();

			}

		};
		view.getButtonFindPunishment().addActionListener(findPunishmentAction);
		
		payForAllPunishmentsAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.payForAllPunishments();

			}

		};
		view.getButtonPayForAll().addActionListener(payForAllPunishmentsAction);

	}

}
