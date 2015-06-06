package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.FoundPunishment;

public class PunishmentOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public List<FoundPunishment> findAllPunishmentsById(int readerId,
			String rights) {
		try {
			List<FoundPunishment> resultList = new ArrayList<FoundPunishment>();
			createAppropriateConnection(rights);

			String sql = "SELECT * from Punishments_Found where id = ?";
			st = con.prepareStatement(sql);

			st.setInt(1, readerId);
			rs = st.executeQuery();
			while (rs.next()) {
				FoundPunishment punishment = new FoundPunishment();
				punishment.setId(rs.getInt("id"));
				punishment.setBorrowingId(rs.getInt("borrowing_id"));
				punishment.setName(rs.getString("name"));
				punishment.setSurname(rs.getString("surname"));
				punishment.setTitle(rs.getString("title"));
				punishment.setAmount(rs.getFloat("amount"));
				punishment.setBorrowingDate(rs.getString("when_borrowed"));
				punishment.setPunishmentDate(rs.getString("when_punished"));
				resultList.add(punishment);
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

	public boolean payForAllPunishments(int[] borrowingsIds, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "UPDATE Punishments SET end_date = current_timestamp WHERE borrowing_id = ?";
			st = con.prepareStatement(sql);
			for (int id : borrowingsIds) {
				st.setInt(1, id);
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
