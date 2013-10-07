package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import veilingActions.database.DatabaseQuery;

public class RegisterDAO {
	
	public static boolean createUser(String voornaam, String tussenvoegsel, String achternaam, String adress, String postcode, String email, String password, String telefoonnummer, String rekeningnummer, String plaats){
		Connection connection = null;
		boolean b = true;
		try {
			DatabaseQuery.getDBConnection();
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl",
					"tho5_2013_2a_team3", "welkom_02");
			if (connection != null) {
				System.out.println("Connectie geslaagd");
			} else {
				System.out.println("Mislukt");
				b= false;
			}

		} catch (SQLException e) {

			System.out.println("Connectie mislukt!");
			e.printStackTrace();
		}
		DatabaseQuery.insertRecordsToDbUserTable("INSERT INTO GEBRUIKERS (VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM, ADRES, POSTCODE, EMAIL, WACHTWOORD, TELEFOONNUMMER, REKENINGNUMMER, PLAATS) VALUES ('"+voornaam +"', '"+tussenvoegsel+"', '"+achternaam+"', '"+adress+"', '"+postcode+"', '"+email+"', '"+password+"', '"+telefoonnummer+"', '"+rekeningnummer+"', '"+plaats+"')");
		return b;
	}

}
