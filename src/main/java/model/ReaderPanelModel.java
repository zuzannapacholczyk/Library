package model;

import database.ReaderOperations;
import entities.Reader;
import view.ErrorDialog;
import view.ReaderPanelView;

public class ReaderPanelModel {

	private ReaderPanelView view;

	public ReaderPanelModel(ReaderPanelView readerPanelView) {
		this.view = readerPanelView;
	}

	public void addReader() {
		Reader reader = new Reader();
		reader.setName(view.getNameTextField());
		reader.setSurname(view.getSurnameTextField());
		reader.setAddress(view.getAddress());
		reader.setEmail(view.getEmailTextField());
		ReaderOperations readerOperations = new ReaderOperations();
		if (readerOperations.addReader(reader, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Czytelnik dodany do bazy");
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Blad danych.");
		}
	}

	public void removeReader() {
		if (view.getIdTextField().length() > 0) {
			int id = Integer.parseInt(view.getIdTextField());
			ReaderOperations readerOperations = new ReaderOperations();
			if (readerOperations.removeReader(id, view.getRights())) {
				ErrorDialog error = new ErrorDialog();
				error.showSuccess("Czytelnik poprawnie usuniety");
			} else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Brak czytelnika o podanych danych");
			}
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Podaj numer czytelnika");
		}
	}

	public void updateReader() {
		Reader reader = new Reader();
		if (view.getIdTextField().length() > 0) {
			reader.setId(Integer.parseInt(view.getIdTextField()));
			ReaderOperations readerOperations = new ReaderOperations();
			Reader foundReader = readerOperations.getReaderById(reader.getId(),
					view.getRights());
			if (foundReader == null) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Brak czytelnika o podanym numerze");
			} else {
				view.setNameTextField(foundReader.getName());
				view.setSurnameTextField(foundReader.getSurname());
				view.setAddress(foundReader.getAddress());
				view.setEmailTextField(foundReader.getEmail());
				view.getChangeButton().setText("Zatwierdz");
			}
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Podaj numer czytelnika");
		}

	}

	public void changeReader() {
		Reader reader = new Reader();
		if (view.getIdTextField().length() > 0)
			reader.setId(Integer.parseInt(view.getIdTextField()));
		reader.setName(view.getNameTextField());
		reader.setSurname(view.getSurnameTextField());
		reader.setAddress(view.getAddress());
		reader.setEmail(view.getEmailTextField());
		ReaderOperations readerOperations = new ReaderOperations();
		if (readerOperations.updateReader(reader, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Poprawnie zmieniono dane czytelnika");
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Blad podczas wprowadzania zmian.");
		}
		view.getChangeButton().setText("Zmien");
	}

	public void clearFormular() {
		view.setAddress("");
		view.setIdTextField("");
		view.setNameTextField("");
		view.setSurnameTextField("");
		view.setEmailTextField("");
	}
}
