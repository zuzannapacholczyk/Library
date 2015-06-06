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
		if(result.size()>0)
			for(FoundPunishment punishment : result) {
				model.addRow(punishment.changeIntoList().toArray());
			}
		
	}

	public void findPunishments() {
		removeAllFromTable();
		int id;
		String name;
		String surname;
		
		name = view.getNameTextField();
		surname = view.getSurnameTextField();
		
		PunishmentOperations punishmentOperations = new PunishmentOperations();

		if (view.getIdTextField().length() > 0) {
			id = Integer.parseInt(view.getIdTextField());
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
		if (resultList == null || resultList.size() == 0) {
			ErrorDialog error = new ErrorDialog();
			error.showError("Brak kar do oplacenia");
		}
		else {
			int[] borrowingIds = {};
			int i = 0;
			for(FoundPunishment punishment : resultList) {
				borrowingIds[i] = punishment.getBorrowingId();
				i++;
			}
			PunishmentOperations punishmentOperations = new PunishmentOperations();
			if(punishmentOperations.payForAllPunishments(borrowingIds, view.getRights())) {
				ErrorDialog error = new ErrorDialog();
				error.showSuccess("Pomyslnie oplacono");
			}
			else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Blad przy wprowadzaniu oplat");
			}
		}

	}

	public void clean() {
		removeAllFromTable();
		view.setIdTextField("");
		view.setNameTextField("");
		view.setSurnameTextField("");	
	}
	
	private void removeAllFromTable() {
		DefaultTableModel model = (DefaultTableModel) this.view
				.getResultTable().getModel();
		for (int i = 0; i < model.getRowCount(); i++)
			model.removeRow(i);

	}

	public void payForPunishment(int row) {
		PunishmentOperations punishmentOperations = new PunishmentOperations();
		int[] borrowingId = {resultList.get(row).getBorrowingId()};
		if(punishmentOperations.payForAllPunishments(borrowingId, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Pomyslnie oplacono");
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Blad przy wprowadzaniu oplat");
		}
	}

}
