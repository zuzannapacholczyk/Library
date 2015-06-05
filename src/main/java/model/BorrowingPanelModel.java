package model;

import java.util.List;

import database.BorrowingOperations;
import database.SearchBookOperations;
import database.SearchReaderOperations;
import entities.BookCopy;
import entities.Reader;
import view.BorrowingPanelView;
import view.ErrorDialog;

public class BorrowingPanelModel {

	private BorrowingPanelView view;

	public BorrowingPanelModel(BorrowingPanelView borrowingPanelView) {
		this.view = borrowingPanelView;
	}

	public void borrowBook() {
		Reader reader = new Reader();
		BookCopy book = new BookCopy();
		SearchReaderOperations searchReader = new SearchReaderOperations();
		SearchBookOperations searchBook = new SearchBookOperations();
		book = findBookById(book, searchBook);
		if (view.getReaderIdTextField().length() == 0) {
			reader = findReaderByNameAndSurname(searchReader);
		} else {
			reader = findReaderById(book, searchReader);
		}
		
		BorrowingOperations borrowingOperations = new BorrowingOperations();
		if(borrowingOperations.borrowBook(book.getId(), reader.getId(), view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Wypozyczono pomyslnie");
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Blad wypozyczenia");
		}

	}

	private Reader findReaderByNameAndSurname(SearchReaderOperations searchReader) {
		Reader reader;
		List<Reader> resultList;
		String name = view.getReaderNameTextField();
		String surname = view.getReaderSurnameTextField();
		if (name.length() == 0 && surname.length() == 0) {
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz podac dane czytelnika");
		} else if (name.length() > 0 && surname.length() > 0) {
			resultList = searchReader.findReaderByNameAndSurname(name,
					surname, view.getRights());
			if (resultList.size() > 1 || resultList.size() == 0) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Niejednoznaczne dane czytelnika");
			} else {
				reader = resultList.get(0);
				return reader;
			}
		} else if (surname.length() > 0) {
			resultList = searchReader.findReaderBySurname(surname,
					view.getRights());
			if (resultList.size() > 1 || resultList.size() == 0) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Niejednoznaczne dane czytelnika");
			} else {
				reader = resultList.get(0);
				return reader;
			}
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Niejednoznaczne dane czytelnika");
		}
		return null;
	}

	private BookCopy findBookById(BookCopy book, SearchBookOperations searchBook) {
		int bookId;
		if (view.getBookIdField().length() == 0) {
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz podac numer ksiazki");
		} else {
			bookId = Integer.parseInt(view.getBookIdField());
			book = searchBook.findBookById(bookId, view.getRights());
			if (book == null) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Bledny numer ksiazki");
			}
		}
		return book;
	}

	private Reader findReaderById(BookCopy book,
			SearchReaderOperations searchReader) {
		Reader reader;
		int readerId;
		readerId = Integer.parseInt(view.getReaderIdTextField());
		reader = searchReader.findReaderById(readerId, view.getRights());
		if (reader == null) {
			if (book == null) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Brak czytelnika o podanym id");
			}
		}
		return reader;
	}

	public void returnBook() {
		// TODO Auto-generated method stub

	}

}
