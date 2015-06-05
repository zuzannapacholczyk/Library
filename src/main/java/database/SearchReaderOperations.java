package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Reader;

public class SearchReaderOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public List<Reader> findReaderByNameAndSurname(String name, String surname,
			String rights) {
		try {
			List<Reader> resultList = new ArrayList<Reader>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM readers WHERE LOWER(name) LIKE ? AND LOWER(surname) LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1, "%" + name + "%");
			st.setString(2, "%" + surname + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setId(rs.getInt("id"));
				reader.setName(rs.getString("name"));
				reader.setSurname(rs.getString("surname"));
				reader.setAddress(rs.getString("address"));
				reader.setEmail(rs.getString("email"));
				resultList.add(reader);
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
	
	public List<Reader> findReaderBySurname(String surname,
			String rights) {
		try {
			List<Reader> resultList = new ArrayList<Reader>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM readers WHERE LOWER(surname) LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(2, "%" + surname + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setId(rs.getInt("id"));
				reader.setName(rs.getString("name"));
				reader.setSurname(rs.getString("surname"));
				reader.setAddress(rs.getString("address"));
				reader.setEmail(rs.getString("email"));
				resultList.add(reader);
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

	public Reader findReaderById(int id, String rights) {
		try {
			Reader reader = new Reader();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM readers WHERE id = ?";
			st = con.prepareStatement(sql);

			st.setInt(1, id);

			rs = st.executeQuery();
			if (rs.next()) {
				
				reader.setId(rs.getInt("id"));
				reader.setName(rs.getString("name"));
				reader.setSurname(rs.getString("surname"));
				reader.setAddress(rs.getString("address"));
				reader.setEmail(rs.getString("email"));
			}

			return reader;

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
