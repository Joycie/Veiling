package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import veilingActions.database.GetConnection;
import veilingDomain.Gebruiker;
import veilingInterface.VeilingInterface;


public class GebruikerDAO implements VeilingInterface<Gebruiker> {

	@Override
	public void create(Object T) {
		Gebruiker gebruiker = (Gebruiker) T;
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		if (connection != null) {
			System.out.println("|| Connection ready || ");
		} else {
			System.out.println("|| Connection failed ||");
		}
		try {
			System.out.println(" || Excecuting query ");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO GEBRUIKERS (VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM, ADRES, POSTCODE, EMAIL, WACHTWOORD, TELEFOONNUMMER, REKENINGNUMMER, PLAATS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,gebruiker.getVoornaam());
			ps.setString(2,gebruiker.getTussenvoegsel());
			ps.setString(3,gebruiker.getAchternaam());
			ps.setString(4,gebruiker.getAdres());
			ps.setString(5,gebruiker.getPostcode());
			ps.setString(6,gebruiker.getEmail());
			ps.setString(7,gebruiker.getWachtwoord());
			ps.setInt(8,gebruiker.getTelefoonnummer());
			ps.setInt(9,gebruiker.getRekeningnummer());
			ps.setString(10,gebruiker.getPlaats());
			
			ResultSet rs = ps.executeQuery();
			
			ps.close();
			rs.close();
	
		} catch (SQLException e) {
	
			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
	@Override
	public Gebruiker retrieve(String email) {
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
	public void update(Object T) {
		
	}
	@Override
	public void delete(Object T) {
		// TODO Auto-generated method stub
		
	}
}
