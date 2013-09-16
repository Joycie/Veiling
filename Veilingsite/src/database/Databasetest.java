package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databasetest {

	public static void main(String[] argv) {

		System.out.println("-------- Database connectie test. ------");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl",
					"tho5_2013_2a_team3", "welkom_02");
			selectRecordsFromDbUserTable();
			if (connection != null) {
				System.out.println("Connectie geslaagd");
			} else {
				System.out.println("Mislukt");
			}

		} catch (SQLException e) {

			System.out.println("Connectie mislukt!");
			e.printStackTrace();
			return;

		}

		
	}

	private static void selectRecordsFromDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT EMAIL, WACHTWOORD from GEBRUIKERS";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				String email = rs.getString("EMAIL");
				String wachtwoord = rs.getString("WACHTWOORD");

				System.out.println("Username eerste record : " + email);
				System.out.println("Password eerste record : " + wachtwoord);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
					"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl",
					"tho5_2013_2a_team3", "welkom_02");
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}