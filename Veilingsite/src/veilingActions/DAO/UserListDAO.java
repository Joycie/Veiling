package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingDomain.Gebruiker;

public class UserListDAO {
	private static String voornaam, tussenvoegsel, achternaam, adres, postcode,
			plaats, email, wachtwoord;
	private static int klantnummer, telefoonnummer, rekeningnummer;
	private static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();

	public static void validate() {
		Gebruiker gebruiker = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection.prepareStatement("SELECT KLANTNR, VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM from GEBRUIKERS");
			ResultSet rs = ps.executeQuery();
			gebruikerslijst.clear();
			while (rs.next()) {
				klantnummer = rs.getInt("klantnr");
				voornaam = rs.getString("VOORNAAM");
				tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				achternaam = rs.getString("ACHTERNAAM");
				Gebruiker geb = new Gebruiker(klantnummer, voornaam,
						tussenvoegsel, achternaam, "", "", "", "", "", 0, 0, 0, 0);
				gebruikerslijst.add(geb);
				System.out.println("Klantnr: " + klantnummer + " || voornaam: "
						+ voornaam + " || tussenvoegsel: " + tussenvoegsel
						+ " || achternaam " + achternaam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}

	public static String getVoornaam() {
		return voornaam;
	}

	public static void setVoornaam(String voornaam) {
		UserListDAO.voornaam = voornaam;
	}

	public static String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public static void setTussenvoegsel(String tussenvoegsel) {
		UserListDAO.tussenvoegsel = tussenvoegsel;
	}

	public static String getAchternaam() {
		return achternaam;
	}

	public static void setAchternaam(String achternaam) {
		UserListDAO.achternaam = achternaam;
	}

	public static String getAdres() {
		return adres;
	}

	public static void setAdres(String adres) {
		UserListDAO.adres = adres;
	}

	public static String getPostcode() {
		return postcode;
	}

	public static void setPostcode(String postcode) {
		UserListDAO.postcode = postcode;
	}

	public static String getPlaats() {
		return plaats;
	}

	public static void setPlaats(String plaats) {
		UserListDAO.plaats = plaats;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		UserListDAO.email = email;
	}

	public static String getWachtwoord() {
		return wachtwoord;
	}

	public static void setWachtwoord(String wachtwoord) {
		UserListDAO.wachtwoord = wachtwoord;
	}

	public static int getKlantnummer() {
		return klantnummer;
	}

	public static void setKlantnummer(int klantnummer) {
		UserListDAO.klantnummer = klantnummer;
	}

	public static int getTelefoonnummer() {
		return telefoonnummer;
	}

	public static void setTelefoonnummer(int telefoonnummer) {
		UserListDAO.telefoonnummer = telefoonnummer;
	}

	public static int getRekeningnummer() {
		return rekeningnummer;
	}

	public static void setRekeningnummer(int rekeningnummer) {
		UserListDAO.rekeningnummer = rekeningnummer;
	}

	public static ArrayList<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}

	public static void setGebruikerslijst(ArrayList<Gebruiker> gebruikerslijst) {
		UserListDAO.gebruikerslijst = gebruikerslijst;
	}

}