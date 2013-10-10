package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import veilingActions.database.GetConnection;
import veilingDomain.Gebruiker;
import veilingInterface.VeilingInterface;

public class RegisterDAO {
	
	public static boolean createUser(String voornaam, String tussenvoegsel, String achternaam, String adress, String postcode, String email, String password, String telefoonnummer, String rekeningnummer, String plaats){
		boolean b = true;
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
				b= false;
			}
		try {
			System.out.println(" || Excecuting query ");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO GEBRUIKERS (VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM, ADRES, POSTCODE, EMAIL, WACHTWOORD, TELEFOONNUMMER, REKENINGNUMMER, PLAATS) VALUES ('"+voornaam +"', '"+tussenvoegsel+"', '"+achternaam+"', '"+adress+"', '"+postcode+"', '"+email+"', '"+password+"', '"+telefoonnummer+"', '"+rekeningnummer+"', '"+plaats+"')");
			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {

			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return b;
	}
}
