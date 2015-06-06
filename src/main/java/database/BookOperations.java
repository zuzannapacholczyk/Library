package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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


}
