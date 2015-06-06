package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Reader;

public class ReaderOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public Reader getReaderById(int id, String rights) {
		try {
			Reader reader = null;
			createAppropriateConnection(rights);
			String sql = "SELECT * FROM readers WHERE id = ? ";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				reader = new Reader();
				reader.setId(Integer.parseInt(rs.getString("id")));
				reader.setAddress(rs.getString("address"));
				reader.setName(rs.getString("name"));
				reader.setSurname(rs.getString("surname"));
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

	public boolean addReader(Reader reader, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO readers(name, surname, address, email) VALUES (?, ?, ?, ?)";
			st = con.prepareStatement(sql);

			st.setString(1, reader.getName());
			st.setString(2, reader.getSurname());
			st.setString(3, reader.getAddress());
			st.setString(4, reader.getEmail());
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

	public boolean removeReader(int id, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM readers WHERE id = ?";
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

	public boolean updateReader(Reader reader, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "UPDATE Readers SET name = ?, surname = ?, address = ?, email = ? WHERE id = ?";
			st = con.prepareStatement(sql);

			st.setString(1, reader.getName());
			st.setString(2, reader.getSurname());
			st.setString(3, reader.getAddress());
			st.setString(4, reader.getEmail());
			st.setInt(5, reader.getId());
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
}
