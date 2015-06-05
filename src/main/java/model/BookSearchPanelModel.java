package model;

import java.util.ArrayList;
import java.util.List;

import database.SearchOperations;
import entities.FoundBook;
import view.BookSearchPanelView;
import view.ErrorDialog;

public class BookSearchPanelModel {

	private BookSearchPanelView view;

	public BookSearchPanelModel(BookSearchPanelView view) {
		this.view = view;
		this.setListElements();
	}

	private void setListElements() {
		String[] list = { "Tytul", "Autor", "Wydawnictwo", "Dzial" };
		this.view.setListElements(list);

	}

	public void searchForBook() {
		String phrase = this.view.getPhrase();

		if (phrase.length() > 0) {
			phrase = phrase.toLowerCase();
			int[] chosenElements = this.view.getChosenListElements();
			if (chosenElements.length > 0) {
				List<FoundBook> result = new ArrayList<FoundBook>();
				String[] words = phrase.split("\\s+|\\s*,\\s*");
				SearchOperations search = new SearchOperations();
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
			} else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Musisz wybrac, gdzie mam szukac");
			}
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz wpisac fraze do wyszukania");
		}

	}

}
