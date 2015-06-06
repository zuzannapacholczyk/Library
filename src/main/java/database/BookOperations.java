package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.BookCopy;

public class BookOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public boolean removeBookById(int id, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM Books WHERE id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			return true;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

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

	public boolean removeBookByTitle(String title, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM Books WHERE LOWER(title) LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1, "%" + title + "%");
			st.executeUpdate();
			return true;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

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

	public boolean removeCopyById(int id, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM Book_Copies WHERE id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			return true;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

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

	public boolean addBook(String title, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO Books(title) VALUES(?)";
			st = con.prepareStatement(sql);
			st.setString(1, title);
			st.executeUpdate();
			return true;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

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

	public boolean addAuthorBookRelation(List<Integer> authorIds, int bookId,
			String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO Authors_Books(author_id, book_id) VALUES(?, ?)";
			st = con.prepareStatement(sql);
			for (int id : authorIds) {
				st.setInt(1, id);
				st.setInt(2, bookId);
				st.executeUpdate();
			}
			return true;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

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

	public boolean addCopy(BookCopy bookCopy, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO Book_Copies(book_id, issue_number, department_id, publisher) VALUES(?, ?, ?, ?)";
			st = con.prepareStatement(sql);

			st.setInt(1, bookCopy.getBookId());
			st.setString(2, bookCopy.getIssueNumber());
			st.setInt(3, bookCopy.getDepartmentId());
			st.setString(4, bookCopy.getPublisher());
			st.executeUpdate();

			return true;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

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

}
