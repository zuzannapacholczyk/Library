package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.BookCopy;
import entities.FoundBook;

public class SearchBookOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public List<FoundBook> findBookByTitle(String[] words, String rights) {
		try {
			List<FoundBook> resultList = new ArrayList<FoundBook>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM books_found WHERE LOWER(title) LIKE ?";
			st = con.prepareStatement(sql);
			for (String word : words) {
				st.setString(1, "%" + word + "%");
				rs = st.executeQuery();
				while (rs.next()) {
					FoundBook book = new FoundBook();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setAuthorName(rs.getString("name"));
					book.setAuthorSurname(rs.getString("surname"));
					book.setIssueNumber(rs.getString("issue_number"));
					book.setDepartmentId(rs.getInt("department_id"));
					book.setPublisher(rs.getString("publisher"));
					book.setIfAvailable(rs.getBoolean("availability"));
					resultList.add(book);
				}
			}

			return resultList;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}

	public List<FoundBook> findBookByAuthor(String[] words, String rights) {
		try {
			List<FoundBook> resultList = new ArrayList<FoundBook>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM books_found WHERE LOWER(name) LIKE ? OR LOWER(surname) LIKE ?";
			st = con.prepareStatement(sql);
			for (String word : words) {
				st.setString(1, "%" + word + "%");
				st.setString(2, "%" + word + "%");
				rs = st.executeQuery();
				while (rs.next()) {
					FoundBook book = new FoundBook();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setAuthorName(rs.getString("name"));
					book.setAuthorSurname(rs.getString("surname"));
					book.setIssueNumber(rs.getString("issue_number"));
					book.setDepartmentId(rs.getInt("department_id"));
					book.setPublisher(rs.getString("publisher"));
					book.setIfAvailable(rs.getBoolean("availability"));
					resultList.add(book);
				}
			}

			return resultList;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}

	public List<FoundBook> findBookByDepartment(String[] words, String rights) {
		try {
			List<FoundBook> resultList = new ArrayList<FoundBook>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM books_found JOIN departmens ON (books_found.department_id = departments.id) WHERE LOWER(departments.name) LIKE ?";
			st = con.prepareStatement(sql);
			for (String word : words) {
				st.setString(1, "%" + word + "%");
				rs = st.executeQuery();
				while (rs.next()) {
					FoundBook book = new FoundBook();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setAuthorName(rs.getString("name"));
					book.setAuthorSurname(rs.getString("surname"));
					book.setIssueNumber(rs.getString("issue_number"));
					book.setDepartmentId(rs.getInt("department_id"));
					book.setPublisher(rs.getString("publisher"));
					book.setIfAvailable(rs.getBoolean("availability"));
					resultList.add(book);
				}
			}

			return resultList;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}

	public List<FoundBook> findBookByPublisher(String[] words, String rights) {
		try {
			List<FoundBook> resultList = new ArrayList<FoundBook>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM books_found WHERE LOWER(publisher) LIKE ?";
			st = con.prepareStatement(sql);
			for (String word : words) {
				st.setString(1, "%" + word + "%");
				rs = st.executeQuery();
				while (rs.next()) {
					FoundBook book = new FoundBook();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setAuthorName(rs.getString("name"));
					book.setAuthorSurname(rs.getString("surname"));
					book.setIssueNumber(rs.getString("issue_number"));
					book.setDepartmentId(rs.getInt("department_id"));
					book.setPublisher(rs.getString("publisher"));
					book.setIfAvailable(rs.getBoolean("availability"));
					resultList.add(book);
				}
			}

			return resultList;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}

	public BookCopy findBookCopyById(int bookId, String rights) {
		try {
			BookCopy book = new BookCopy();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM book_copies WHERE id = ?";
			st = con.prepareStatement(sql);

			st.setInt(1, bookId);
			rs = st.executeQuery();
			if (rs.next()) {

				book.setId(rs.getInt("id"));
				book.setBookId(rs.getInt("book_id"));
				book.setIssueNumber(rs.getString("issue_number"));
				book.setDepartmentId(rs.getInt("department_id"));
				book.setPublisher(rs.getString("publisher"));
			}

			return book;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}

	}
	
	public int findBookItemByTitle(String title, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM Books WHERE LOWER(title) LIKE ?";
			st = con.prepareStatement(sql);

			st.setString(1, title);
			rs = st.executeQuery();
			if (rs.next()) {

				return rs.getInt("id");
			}

			return -1;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return -1;

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}

	}

	private void createAppropriateConnection(String rights) {
		Database db = new Database();
		if (rights.equals("l")) {
			con = db.startLibrarianConnection();
		} else if (rights.equals("a"))
			con = db.startAdminConnection();
		else
			con = db.startReaderConnection();

	}

}
