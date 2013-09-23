package veilingActions.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.driver.OracleDriver;
import veilingDomain.Gebruiker;

public class DatabaseQuery {
	
	private static int klantnr;
	private static String voornaam;
	private static String tussenvoegsel = "";
	private static String achternaam;
	
	private static ArrayList<Gebruiker> gebruikers = new ArrayList<Gebruiker>();

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

	public static void selectUsersfromGebruikers(String selectTableSQL) {
		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(selectTableSQL);
			gebruikers.clear();
			while (rs.next()) {
				klantnr = rs.getInt("KLANTNR");
				voornaam = rs.getString("VOORNAAM");
				tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				achternaam = rs.getString("ACHTERNAAM");
				Gebruiker geb = new Gebruiker(klantnr, voornaam, tussenvoegsel, achternaam, "", "", "", "", "", 0, 0);
				gebruikers.add(geb);
				System.out.println("Klantnr: " + klantnr + " || voornaam: " +  voornaam
						+  " || tussenvoegsel: " + tussenvoegsel + " || achternaam " + achternaam);
			}
			System.out.println(gebruikers.toString());
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
	public static void insertRecordsToDbUserTable(String insertTableSQL) {

		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			statement.executeQuery(insertTableSQL);
			

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

	public static int getKlantnr() {
		return klantnr;
	}

	public static void setKlantnr(int klantnr) {
		DatabaseQuery.klantnr = klantnr;
	}

	public static String getVoornaam() {
		return voornaam;
	}

	public static void setVoornaam(String voornaam) {
		DatabaseQuery.voornaam = voornaam;
	}

	public static String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public static ArrayList<Gebruiker> getGebruikers() {
		return gebruikers;
	}

	public static void setGebruikers(ArrayList<Gebruiker> gebruikers) {
		DatabaseQuery.gebruikers = gebruikers;
	}

	public static void setTussenvoegsel(String tussenvoegsel) {
		DatabaseQuery.tussenvoegsel = tussenvoegsel;
	}

	public static String getAchternaam() {
		return achternaam;
	}

	public static void setAchternaam(String achternaam) {
		DatabaseQuery.achternaam = achternaam;
	}


}