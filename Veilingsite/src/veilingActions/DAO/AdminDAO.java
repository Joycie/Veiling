package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingDomain.Gebruiker;
import veilingInterface.VeilingInterface;

public class AdminDAO<T> implements VeilingInterface<T> {
	private static String voornaam, tussenvoegsel, achternaam, adres, postcode,
			plaats, email, wachtwoord;
	private static int klantnummer, telefoonnummer, rekeningnummer, rol;
	private static double krediet;
	private static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();

	@Override
	public boolean create(Object T) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T retrieve(String ID) {
		Gebruiker gebruiker = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("SELECT * from GEBRUIKERS");
			ResultSet rs = ps.executeQuery();
			gebruikerslijst.clear();
			while (rs.next()) {
				klantnummer = rs.getInt("KLANTNR");
				voornaam = rs.getString("VOORNAAM");
				tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				achternaam = rs.getString("ACHTERNAAM");
				adres = rs.getString("ADRES");
				postcode = rs.getString("POSTCODE");
				plaats = rs.getString("PLAATS");
				email = rs.getString("EMAIL");
				telefoonnummer = rs.getInt("TELEFOONNUMMER");
				rekeningnummer = rs.getInt("REKENINGNUMMER");
				krediet = rs.getDouble("KREDIET");
				rol = rs.getInt("ROL");

				
				Gebruiker geb = new Gebruiker(klantnummer, voornaam,
						tussenvoegsel, achternaam, adres, postcode, plaats,
						email, "", telefoonnummer, rekeningnummer, krediet, rol);
				gebruikerslijst.add(geb);
				System.out.println("Klantnr: " + klantnummer + " || voornaam: "
						+ voornaam + " || tussenvoegsel: " + tussenvoegsel
						+ " || achternaam " + achternaam);
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return null;
	}

	@Override
	public boolean update(Object T) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Object T) {
		// TODO Auto-generated method stub

	}

	public Gebruiker retrieveUser(int klantnummer) {
		Gebruiker gebruiker = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("SELECT * from GEBRUIKERS WHERE KLANTNR =" +  klantnummer);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				voornaam = rs.getString("VOORNAAM");
				tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				achternaam = rs.getString("ACHTERNAAM");
				adres = rs.getString("ADRES");
				postcode = rs.getString("POSTCODE");
				plaats = rs.getString("PLAATS");
				email = rs.getString("EMAIL");
				telefoonnummer = rs.getInt("TELEFOONNUMMER");
				rekeningnummer = rs.getInt("REKENINGNUMMER");
				krediet = rs.getDouble("KREDIET");
				rol = rs.getInt("ROL");
			}
			ps.close();
			rs.close();
			gebruiker = new Gebruiker(klantnummer, voornaam, tussenvoegsel,
					achternaam, adres, postcode, plaats, email, "",
					telefoonnummer, rekeningnummer, krediet, rol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return gebruiker;
	}
	public void blockUser(int klantnummer)
	{
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET ROL = 2 WHERE KLANTNR =" +  klantnummer);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
	public void deblockUser(int klantnummer)
	{
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET ROL = 0 WHERE KLANTNR =" +  klantnummer);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
	public static ArrayList<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}

	public static void setGebruikerslijst(ArrayList<Gebruiker> gebruikerslijst) {
		AdminDAO.gebruikerslijst = gebruikerslijst;
	}

}