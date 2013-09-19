package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.driver.OracleDriver;
import domein.Gebruiker;


public class Databasetest {

	private String email = "aa";
	private String wachtwoord = "bb";
	private ArrayList<Gebruiker> gebruikers = new ArrayList<Gebruiker>();
	public static void main(String[] argv) {

		System.out.println("-------- Database connectie test. ------");
		Databasetest dbt = new Databasetest();
		Connection connection = null;

		Databasetest.getDBConnection();
		if (connection != null) {
			System.out.println("Connectie geslaagd");
		} else {
			System.out.println("Mislukt");
		}
		try {
				dbt.selectRecordsFromDbUserTable();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void selectRecordsFromDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT EMAIL, WACHTWOORD from GEBRUIKERS";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				email = rs.getString("EMAIL");
			    wachtwoord = rs.getString("WACHTWOORD");

				System.out.println("Username: " + email + " || Password: " + wachtwoord);

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

	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			 Class.forName("oracle.jdbc.OracleDriver") ;
		     System.out.println("Oracle JDBC driver loaded ok.");

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver.");
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
	public String getEmail()
	{
		return email;
	}
	public String setWachtwoord()
	{
		return wachtwoord;
	}

}