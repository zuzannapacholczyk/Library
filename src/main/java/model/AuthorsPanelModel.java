package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import database.AuthorOperations;
import entities.Author;
import view.AuthorsPanelView;
import view.ErrorDialog;

public class AuthorsPanelModel {

	private AuthorsPanelView view;

	public AuthorsPanelModel(AuthorsPanelView authorsView) {
		this.view = authorsView;
		this.setColumnsInTable();
	}

	private void setColumnsInTable() {
		DefaultTableModel model = (DefaultTableModel) this.view
				.getResultTable().getModel();

		model.addColumn("Id");
		model.addColumn("Imie");
		model.addColumn("Nazwisko");
	}

	public void addAuthor() {
		String name = view.getNameTextField();
		String surname = view.getSurnameTextField();
		AuthorOperations authorOperations = new AuthorOperations();
		if (authorOperations.addAuthor(name, surname, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Autor dodany do bazy");
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Operacja sie nie powiodla");
		}
	}

	public void removeAuthor() {

		AuthorOperations authorOperations = new AuthorOperations();
		int id;
		if (view.getIdTextField().length() == 0) {
			String name = view.getNameTextField();
			String surname = view.getSurnameTextField();
			List<Author> result = authorOperations.findAutorByNameAndSurname(
					name, surname, view.getRights());
			if (result.size() == 0) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Brak autora o podanych danych");
			} else if (result.size() > 1) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Niejednoznaczne informacje");
			} else {
				id = result.get(0).getId();
			}
		} else {
			id = Integer.parseInt(view.getIdTextField());
			if (authorOperations.deleteAuthorById(id, view.getRights())) {
				ErrorDialog error = new ErrorDialog();
				error.showSuccess("Autor usuniety z bazy");
			} else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Operacja sie nie powiodla");
			}
		}
	}

	public void searchForAuthor() {
		removeAllFromTable();
		AuthorOperations authorOperations = new AuthorOperations();
		List<Author> result = new ArrayList<Author>();
		if (view.getIdTextField().length() == 0) {
			String name = view.getNameTextField().toLowerCase();
			String surname = view.getSurnameTextField().toLowerCase();
			result = authorOperations.findAutorByNameAndSurname(name, surname,
					view.getRights());
		} else {
			int id = Integer.parseInt(view.getIdTextField());
			result.add(authorOperations.findAuthorById(id, view.getRights()));
		}
		addRowsToTable(result);
	}

	private void addRowsToTable(List<Author> result) {
		DefaultTableModel model = (DefaultTableModel) this.view
				.getResultTable().getModel();

		for (Author author : result) {
			model.addRow(author.changeIntoList().toArray());
		}

	}

	private void removeAllFromTable() {
		DefaultTableModel model = (DefaultTableModel) this.view
				.getResultTable().getModel();
		for (int i = 0; i < model.getRowCount(); i++)
			model.removeRow(i);

	}

}
