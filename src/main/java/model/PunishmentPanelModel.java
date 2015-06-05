package model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import database.PunishmentOperations;
import database.SearchReaderOperations;
import entities.FoundPunishment;
import entities.Reader;
import view.ErrorDialog;
import view.PunishmentView;

public class PunishmentPanelModel {

	private PunishmentView view;
	List<FoundPunishment> resultList = null;

	public PunishmentPanelModel(PunishmentView punishmentView) {
		this.view = punishmentView;
		this.setColumnsInTable();
	}

	private void setColumnsInTable() {
		DefaultTableModel model = (DefaultTableModel) this.view
				.getResultTable().getModel();

		model.addColumn("Tytul");
		model.addColumn("Imie autora");
		model.addColumn("Nazwisko autora");
		model.addColumn("Wartosc");
		model.addColumn("Data wypozyczenia");
		model.addColumn("Data rozpoczecia kary");
	}
	
	private void addRowsToTable(List<FoundPunishment> result) {
		DefaultTableModel model = (DefaultTableModel) this.view.getResultTable().getModel();
		
		for(FoundPunishment punishment : result) {
			model.addRow(punishment.changeIntoList().toArray());
		}
		
	}

	public void findPunishments() {
		int id;
		String name;
		String surname;
		id = Integer.parseInt(view.getIdTextField());
		name = view.getNameTextField();
		surname = view.getSurnameTextField();
		
		PunishmentOperations punishmentOperations = new PunishmentOperations();

		if (view.getIdTextField().length() > 0) {
			resultList = punishmentOperations.findAllPunishmentsById(id,
					view.getRights());
		} else if (name.length() > 0 && surname.length() > 0) {
			SearchReaderOperations readerOperations = new SearchReaderOperations();
			List<Reader> readerList = readerOperations
					.findReaderByNameAndSurname(name, surname, view.getRights());
			if (readerList.size() > 1 || readerList.size() == 0) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Niejednoznaczne dane czytelnika");
			} else {
				resultList = punishmentOperations.findAllPunishmentsById(
						readerList.get(0).getId(), view.getRights());
			}
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz podac dane czytelnika");
		}
		addRowsToTable(resultList);

	}

	public void payForAllPunishments() {
		// TODO Auto-generated method stub

	}

}
