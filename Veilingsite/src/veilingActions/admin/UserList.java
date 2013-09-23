package veilingActions.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import veilingActions.database.DatabaseQuery;
import veilingDomain.Gebruiker;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserList extends ActionSupport {
	private ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
	private DatabaseQuery DBT;

	public String execute() {
		Connection connection = null;

		try {
			DBT.getDBConnection();
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl",
					"tho5_2013_2a_team3", "welkom_02");
			if (connection != null) {
				System.out.println("Connectie geslaagd");
			} else {
				System.out.println("Mislukt");
			}

		} catch (SQLException e) {

			System.out.println("Connectie mislukt!");
			e.printStackTrace();
		}
		System.out.println("Opvragen van email + wachtwoord: ");
		DatabaseQuery.selectUsersfromGebruikers("SELECT KLANTNR, VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM from GEBRUIKERS");
		gebruikerslijst = DatabaseQuery.getGebruikers();
		return ActionSupport.SUCCESS;
	}

	public List<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}
}