package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import database.SearchBookOperations;
import entities.FoundBook;
import view.BookSearchPanelView;
import view.ErrorDialog;

public class BookSearchPanelModel {

	private BookSearchPanelView view;

	public BookSearchPanelModel(BookSearchPanelView view) {
		this.view = view;
		this.setListElements();
		this.setColumnsInTable();
	}

	private void setListElements() {
		String[] list = { "Tytul", "Autor", "Wydawnictwo", "Dzial" };
		this.view.setListElements(list);

	}
	
	private void setColumnsInTable() {
		DefaultTableModel model = (DefaultTableModel) this.view.getResultTable().getModel();

		model.addColumn("Id");
		model.addColumn("Tytul");
		model.addColumn("Imie autora");
		model.addColumn("Nazwisko autora");
		model.addColumn("Nr dzialu");
		model.addColumn("Wydanie");
		model.addColumn("Wydawnictwo");
		model.addColumn("Czy dostepna");
	}

	public void searchForBook() {
		removeAllFromTable();
		String phrase = this.view.getPhrase();

		if (phrase.length() > 0) {
			phrase = phrase.toLowerCase();
			int[] chosenElements = this.view.getChosenListElements();
			if (chosenElements.length > 0) {
				List<FoundBook> result = new ArrayList<FoundBook>();
				String[] words = phrase.split("\\s+|\\s*,\\s*");
				SearchBookOperations search = new SearchBookOperations();
				createResult(chosenElements, result, words, search);
				addRowsToTable(result);
				
			} else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Musisz wybrac, gdzie mam szukac");
			}
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz wpisac fraze do wyszukania");
		}

	}

	private void addRowsToTable(List<FoundBook> result) {
		DefaultTableModel model = (DefaultTableModel) this.view.getResultTable().getModel();
		
		for(FoundBook book : result) {
			model.addRow(book.changeIntoList().toArray());
		}
		
	}

	private void createResult(int[] chosenElements, List<FoundBook> result,
			String[] words, SearchBookOperations search) {
		for (int i : chosenElements) {
			if (i == 0)
				result.addAll(search.findBookByTitle(words,
						view.getRights()));
			else if (i == 1)
				result.addAll(search.findBookByAuthor(words,
						view.getRights()));
			else if (i == 2)
				result.addAll(search.findBookByPublisher(words,
						view.getRights()));
			else if (i == 3)
				result.addAll(search.findBookByDepartment(words,
						view.getRights()));
		}
	}
	
	private void removeAllFromTable() {
		DefaultTableModel model = (DefaultTableModel) this.view
				.getResultTable().getModel();
		for (int i = 0; i < model.getRowCount(); i++)
			model.removeRow(i);

	}

}
