package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import veilingActions.database.GetConnection;
import veilingDomain.Gebruiker;
import veilingInterface.VeilingInterface;


public class LoginDAO implements VeilingInterface<Gebruiker> {

	@Override
	public void Create(Object T) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Gebruiker Retrieve(String email) {
		Gebruiker geb = null;
			try {
				Connection connection = null;
				connection = GetConnection.getDBConnection();
				if (connection != null) {
					System.out.println("|| Connection ready || ");
				} else {
					System.out.println("|| Connection failed ||");
				}
				PreparedStatement ps=connection.prepareStatement("select * from gebruikers where email=?");
				ps.setString(1,email);
				System.out.println("Gebruiker: " + email);
				ResultSet rs=ps.executeQuery();
				
				while (rs.next()) {
					int klantnummer = rs.getInt("KLANTNR");
					String voornaam = rs.getString("VOORNAAM");
					String tussenvoegsel = rs.getString("TUSSENVOEGSEL");
					String achternaam = rs.getString("ACHTERNAAM");
					String wachtwoord =  rs.getString("WACHTWOORD");
					geb = new Gebruiker(klantnummer, voornaam, tussenvoegsel, achternaam, "", "", "", email, wachtwoord, 0, 0, 0);
					System.out.println("Klantnummer: " +  klantnummer + " | Voornaam: " + voornaam + 
							" | Tussenvoegsel: " + tussenvoegsel + " | Achternaam: " + achternaam + " | Email:  " + email + " | wachtwoord: "+ wachtwoord);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			GetConnection.closeConnection();
			return geb;
	}

	@Override
	public void Update(Object T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Object T) {
		// TODO Auto-generated method stub
		
	}
}
