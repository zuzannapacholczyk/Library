package model;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		List<String> departmentNames = new ArrayList<String>();
		for(Department department : departments) {
			departmentNames.add(department.getName());
		}
		this.view.setListOfDepartments(Arrays.copyOf(departmentNames.toArray(), departmentNames.toArray().length, String[].class));
	}
	
	private void setColumnsInTable() {
		DefaultTableModel model = (DefaultTableModel) this.view.getAuthorResultTable().getModel();

		model.addColumn("Id");
		model.addColumn("Imie");
		model.addColumn("Nazwisko");
	}

	public void addBook() {
		Book book = new Book();
		book.setId(Integer.parseInt(view.getBookIdTextField()));
		book.setTitle(view.getTitleTextField());
		
		BookCopy copy = new BookCopy();
		copy.setId(Integer.parseInt(view.getCopyIdTextField()));
		copy.setBookId(book.getId());
		DepartmentOperations departmentOperations = new DepartmentOperations();
		int departmentId = departmentOperations.findDepartmentIdByName(view.getSelectedDepartment().toLowerCase(), view.getRights());
		copy.setDepartmentId(departmentId);
		
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

	public void addAuthor() {
		// TODO Auto-generated method stub
		
	}

}
