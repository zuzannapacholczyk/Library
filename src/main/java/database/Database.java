package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	String url = "jdbc:postgresql://localhost/biblioteka";
	String user = "administrator";
	String password = "administrator";

	public Connection startConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

			return null;
		}
	}
}
