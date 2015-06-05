package model;

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
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz podac dane czytelnika");
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
		int bookId = 0;
		int readerId = 0;
		if (view.getBookIdField().length() == 0) {
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz podac numer ksiazki");
		} else {
			bookId = Integer.parseInt(view.getBookIdField());
		}
		
		if (view.getReaderIdTextField().length() == 0) {
			ErrorDialog error = new ErrorDialog();
			error.showError("Musisz podac dane czytelnika");
		} else {
			readerId = Integer.parseInt(view.getReaderIdTextField());
		}
	
		BorrowingOperations borrowingOperations = new BorrowingOperations();
		if(borrowingOperations.returnBook(bookId, readerId, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Przyjeto pomyslnie");
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Blad zwrotu");
		}
	}

}
