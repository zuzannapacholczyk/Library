package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import view.PunishmentView;
import model.PunishmentPanelModel;

public class PunishmentPanelController {

	private PunishmentPanelModel model;
	private PunishmentView view;
	private ActionListener findPunishmentAction;
	private ActionListener payForAllPunishmentsAction;
	private ActionListener cleanAction;

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
		
		cleanAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.clean();

			}

		};
		view.getButtonClean().addActionListener(cleanAction);
		
		view.getResultTable().addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		        	model.payForPunishment(row);
		        }
		    }
		});

	}

}
