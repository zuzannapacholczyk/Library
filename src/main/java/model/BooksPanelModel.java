package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import database.BookOperations;
import database.DepartmentOperations;
import database.SearchBookOperations;
import entities.Book;
import entities.BookCopy;
import entities.Department;
import entities.FoundBook;
import view.BooksPanelView;
import view.ErrorDialog;

public class BooksPanelModel {

	private BooksPanelView view;

	public BooksPanelModel(BooksPanelView booksPanelView) {
		this.view = booksPanelView;
		this.setListElements();
		this.setColumnsInTable();
	}
	
	private void setListElements() {
		DepartmentOperations departmentOperations = new DepartmentOperations();
		List<Department> departments = departmentOperations.getDepartments(view.getRights());

		for(Department department : departments) {
			this.view.getListDepartments().addItem(department.getName());
		
		}
	}
	
	private void setColumnsInTable() {
		DefaultTableModel model = (DefaultTableModel) this.view.getAuthorResultTable().getModel();

		model.addColumn("Id");
		model.addColumn("Imie");
		model.addColumn("Nazwisko");
	}

	public void addBook() {
		Book book = new Book();
		book.setTitle(view.getTitleTextField());
		if(book.getTitle().length()>0) {
			BookOperations bookOperations = new BookOperations();
			if(bookOperations.addBook(book.getTitle(), view.getRights())){
				ErrorDialog error = new ErrorDialog();
				addAuthorBookRelation();
				error.showSuccess("Ksiazka dodana");
			}
			else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Nie mozna dodac ksiazki");
			}
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Podaj tytul");
		}
		
	}

	private void addAuthorBookRelation() {
		DefaultTableModel model = (DefaultTableModel) this.view.getAuthorResultTable().getModel();
		if(model.getRowCount() > 0) {
			SearchBookOperations searchBookOperations = new SearchBookOperations();
			int bookId = searchBookOperations.findBookItemByTitle(view.getTitleTextField().toLowerCase(), view.getRights());
			BookOperations bookOperations = new BookOperations();
			List<Integer> authorIds = new ArrayList<Integer>();
			for(int i = 0; i< model.getRowCount(); i++) {
				authorIds.add(Integer.parseInt((String) model.getValueAt(i, 0)));
			}
			if(bookOperations.addAuthorBookRelation(authorIds, bookId, view.getRights())) {
				ErrorDialog error = new ErrorDialog();
				error.showSuccess("Relacja autor - ksiazka utworzona");
			}
			else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Blad w relacji ksiazka - autor, sprobuj ponownie");
			}
		}
	}

	public void removeBook() {
		Book book = new Book();
		book.setTitle(view.getTitleTextField());
		
		BookCopy copy = new BookCopy();
		
		BookOperations bookOperations = new BookOperations();
		if(view.getCopyIdTextField().length() == 0 && (view.getBookIdTextField().length() != 0 || book.getTitle().length() != 0)) {
			//remove book, not copy
			removeBook(book, bookOperations);
		}
		else {
			copy.setId(Integer.parseInt(view.getCopyIdTextField()));
			if(bookOperations.removeCopyById(copy.getId(), view.getRights())) {
				ErrorDialog error = new ErrorDialog();
				error.showSuccess("Egzemplarz usuniety");
			}
			else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Nie mozna usunac egzemplarza");
			}
		}
		
	}

	private void removeBook(Book book, BookOperations bookOperations) {
		if(view.getBookIdTextField().length() != 0 ) {
			//remove by id
			book.setId(Integer.parseInt(view.getBookIdTextField()));
			if(bookOperations.removeBookById(book.getId(), view.getRights())) {
				ErrorDialog error = new ErrorDialog();
				error.showSuccess("Ksiazka usunieta");
			}
			else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Nie mozna usunac ksiazki");
			}
		}
		else {
			//remove by title
			SearchBookOperations searchBookOperations = new SearchBookOperations();
			String[] words = {book.getTitle()};
			List<FoundBook> foundBooks = searchBookOperations.findBookByTitle(words, view.getRights());
			if(foundBooks.size() > 1) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Ten sam tytul posiada kilka ksiazek. Musisz podac id");
			} 
			else {
				if(bookOperations.removeBookByTitle(book.getTitle(), view.getRights())) {
					ErrorDialog error = new ErrorDialog();
					error.showSuccess("Ksiazka usunieta");
				}
				else {
					ErrorDialog error = new ErrorDialog();
					error.showError("Nie mozna usunac ksiazki");
				}
			}
		}
	}

	public void addCopy() {
		BookCopy bookCopy = new BookCopy();
		SearchBookOperations searchBookOperations = new SearchBookOperations();
		BookOperations bookOperations = new BookOperations();
		if(view.getBookIdTextField().length() > 0)
			bookCopy.setBookId(Integer.parseInt(view.getBookIdTextField()));
		else
			bookCopy.setBookId(-1);
		DepartmentOperations departmentOperations = new DepartmentOperations();
		int departmentId = departmentOperations.findDepartmentIdByName(view.getSelectedDepartment().toLowerCase(), view.getRights());
		bookCopy.setDepartmentId(departmentId);
		bookCopy.setIssueNumber(view.getYearTextField());
		bookCopy.setPublisher(view.getIssuerTexField());
		
		Book book = new Book();
		book.setTitle(view.getTitleTextField());
		
		if(bookCopy.getBookId() == -1 && book.getTitle().length() > 0) {
			//find bookId by title
			int bookId = searchBookOperations.findBookItemByTitle(book.getTitle().toLowerCase(), view.getRights());
			if(bookId != -1) {
				bookCopy.setBookId(bookId);
				if(bookOperations.addCopy(bookCopy, view.getRights())) {
					ErrorDialog error = new ErrorDialog();
					error.showSuccess("Egzemplarz poprawnie dodany do bazy");
				}
				else {
					ErrorDialog error = new ErrorDialog();
					error.showError("Wystapil blad. Utworz egzemplarz raz jeszcze");
				}
			}
			else {
				//add book
				if(bookOperations.addBook(book.getTitle(), view.getRights())) {
					bookId = searchBookOperations.findBookItemByTitle(book.getTitle().toLowerCase(), view.getRights());
					bookCopy.setBookId(bookId);
					if(bookOperations.addCopy(bookCopy, view.getRights())) {
						ErrorDialog error = new ErrorDialog();
						error.showSuccess("Egzemplarz poprawnie dodany do bazy");
					}
					else {
						ErrorDialog error = new ErrorDialog();
						error.showError("Wystapil blad. Utworz egzemplarz raz jeszcze");
					}
				}
				else {
					ErrorDialog error = new ErrorDialog();
					error.showError("Wystapil blad. Utworz ksiazke");
				}
			}
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Podaj tytul lub id ksiazki");
		}
	}

	public void clean() {
		removeAllFromTable();
		view.setBookIdTextField("");
		view.setCopyIdTextField("");
		view.setIssuerTextField("");
		view.setYearTextField("");
		view.setTitleTextField("");
	}
	
	private void removeAllFromTable() {
		DefaultTableModel model = (DefaultTableModel) this.view
				.getAuthorResultTable().getModel();
		for (int i = 0; i < model.getRowCount(); i++)
			model.removeRow(i);

	}

}
