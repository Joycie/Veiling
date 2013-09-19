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

	private static String klantnr;
	private static String voornaam;
	private static String tussenvoegsel = "";
	private static String achternaam;
	
	private ArrayList<Gebruiker> gebruikers = new ArrayList<Gebruiker>();

	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
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

	public static void selectRecordsFromDbUserTable(String selectTableSQL) {

		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(selectTableSQL);
			while (rs.next()) {

				klantnr = rs.getString("KLANTNR");
				voornaam = rs.getString("VOORNAAM");
				tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				achternaam = rs.getString("ACHTERNAAM");

				System.out.println("Klantnr: " + klantnr + " || voornaam: " +  voornaam
						+  " || tussenvoegsel: " + tussenvoegsel + " || achternaam " + achternaam);

			}

		} catch (SQLException e) {
			System.out
					.println("Fout in catch van selectRecordsFromDbUserTable()");
			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Kan statement niet sluiten ");
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					System.out.println("Kan connectie niet sluiten ");
					e.printStackTrace();
				}
			}
		}
	}

	public static String getKlantnr() {
		return klantnr;
	}

	public static void setKlantnr(String klantnr) {
		Databasetest.klantnr = klantnr;
	}

	public static String getVoornaam() {
		return voornaam;
	}

	public static void setVoornaam(String voornaam) {
		Databasetest.voornaam = voornaam;
	}

	public static String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public static void setTussenvoegsel(String tussenvoegsel) {
		Databasetest.tussenvoegsel = tussenvoegsel;
	}

	public static String getAchternaam() {
		return achternaam;
	}

	public static void setAchternaam(String achternaam) {
		Databasetest.achternaam = achternaam;
	}

}