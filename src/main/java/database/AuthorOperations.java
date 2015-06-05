package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Author;

public class AuthorOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public boolean addAuthor(String name, String surname, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO authors(name, surname) VALUES(?, ?)";
			st = con.prepareStatement(sql);

			st.setString(1, name);
			st.setString(2, surname);
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

	public boolean deleteAuthorById(int authorId, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM Authors WHERE id = ?";
			st = con.prepareStatement(sql);

			st.setInt(1, authorId);
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

	public Author findAuthorById(int id, String rights) {
		try {
			Author author = new Author();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM Authors WHERE id = ?";
			st = con.prepareStatement(sql);

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {

				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setSurname(rs.getString("surname"));

			}

			return author;

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

	public List<Author> findAutorByNameAndSurname(String name, String surname,
			String rights) {
		try {
			List<Author> resultList = new ArrayList<Author>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM Authors WHERE LOWER(name) LIKE ? AND LOWER(surname) LIKE ?";
			st = con.prepareStatement(sql);

			st.setString(1, "%" + name + "%");
			st.setString(2, "%" + surname + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setSurname(rs.getString("surname"));
				resultList.add(author);
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
