package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.FoundBook;
import entities.User;

public class SearchOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	User user = null;

	public List<FoundBook> findBookByTitle(String[] words, String rights) {
		try {
			List<FoundBook> resultList = new ArrayList<FoundBook>();
			createAppropriateConnection(rights);
			
			String sql = "SELECT * FROM books_found WHERE LOWER(title) LIKE ?";
			st = con.prepareStatement(sql);
			for(String word : words) {
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
			for(String word : words) {
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
			for(String word : words) {
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
			for(String word : words) {
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
