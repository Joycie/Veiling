package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import veilingActions.database.GetConnection;
import veilingDomain.Gebruiker;
import veilingInterface.VeilingInterface;

public class GebruikerDAO implements VeilingInterface<Gebruiker> {

	@Override
	public boolean create(Object T) {
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
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO GEBRUIKERS (VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM, ADRES, POSTCODE, EMAIL, WACHTWOORD, TELEFOONNUMMER, REKENINGNUMMER, PLAATS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, gebruiker.getVoornaam());
			ps.setString(2, gebruiker.getTussenvoegsel());
			ps.setString(3, gebruiker.getAchternaam());
			ps.setString(4, gebruiker.getAdres());
			ps.setString(5, gebruiker.getPostcode());
			ps.setString(6, gebruiker.getEmail());
			ps.setString(7, gebruiker.getWachtwoord());
			ps.setInt(8, gebruiker.getTelefoonnummer());
			ps.setInt(9, gebruiker.getRekeningnummer());
			ps.setString(10, gebruiker.getPlaats());

			ResultSet rs = ps.executeQuery();

			ps.close();
			rs.close();

		} catch (SQLException e) {

			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
			return false;
		}
		GetConnection.closeConnection();
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.ssl.enable", true);
			Session mailSession = Session.getInstance(props);
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("multatuliveiling@gmail.com",
					"Multatuli Veilingen"));
			msg.setRecipients(Message.RecipientType.TO, gebruiker.getEmail());
			msg.setSubject("Uw registratie bij Multatuli Veilingen");
			msg.setSentDate(Calendar.getInstance().getTime());
			msg.setText("Beste " + gebruiker.getVoornaam() + " "
					+ gebruiker.getTussenvoegsel() + " "
					+ gebruiker.getAchternaam()
					+ ", Uw registratie is voltooid \n \n Email: "
					+ gebruiker.getEmail() + "\n Wachtwoord: "
					+ gebruiker.getWachtwoord());
			Transport.send(msg, "multatuliveiling@gmail.com", "register_3");
		} catch (Exception e) {
		}

		return true;
	}

	@Override
	public Gebruiker retrieve(String loginEmail) {
		Gebruiker geb = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("select * from gebruikers where email=?");
			ps.setString(1, loginEmail);
			System.out.println("Gebruiker: " + loginEmail);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int klantnummer = rs.getInt("KLANTNR");
				String voornaam = rs.getString("VOORNAAM");
				String tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				String achternaam = rs.getString("ACHTERNAAM");
				String adres = rs.getString("ADRES");
				String postcode = rs.getString("POSTCODE");
				String email = rs.getString("EMAIL");
				String wachtwoord = rs.getString("WACHTWOORD");
				int telefoonnummer = rs.getInt("TELEFOONNUMMER");
				int rekeningnummer = rs.getInt("REKENINGNUMMER");
				String plaats = rs.getString("PLAATS");
				double krediet = rs.getDouble("KREDIET");
				int rol = rs.getInt("rol");

				geb = new Gebruiker(klantnummer, voornaam, tussenvoegsel,
						achternaam, adres, postcode, plaats, email, wachtwoord,
						telefoonnummer, rekeningnummer, krediet, rol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return geb;
	}
	
	public Gebruiker retrieveById(int klantnr) {
		Gebruiker geb = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("select * from gebruikers where klantnr=?");
			ps.setInt(1, klantnr);
			System.out.println("Gebruiker: " + klantnr);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int klantnummer = rs.getInt("KLANTNR");
				String voornaam = rs.getString("VOORNAAM");
				String tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				String achternaam = rs.getString("ACHTERNAAM");
				String adres = rs.getString("ADRES");
				String postcode = rs.getString("POSTCODE");
				String email = rs.getString("EMAIL");
				String wachtwoord = rs.getString("WACHTWOORD");
				int telefoonnummer = rs.getInt("TELEFOONNUMMER");
				int rekeningnummer = rs.getInt("REKENINGNUMMER");
				String plaats = rs.getString("PLAATS");
				double krediet = rs.getDouble("KREDIET");
				int rol = rs.getInt("rol");

				geb = new Gebruiker(klantnummer, voornaam, tussenvoegsel,
						achternaam, adres, postcode, plaats, email, wachtwoord,
						telefoonnummer, rekeningnummer, krediet, rol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return geb;
	}

	public ArrayList<String> retrieveEmail() {
		ArrayList<String> alle_emails = new ArrayList<String>();
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("select email from gebruikers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String email = rs.getString("email");
				alle_emails.add(email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return alle_emails;

	}

	@Override
	public boolean update(Object T) {
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
			System.out.println("UPDATE GEBRUIKERS SET VOORNAAM = '"
					+ gebruiker.getVoornaam() + "', TUSSENVOEGSEL = '"
					+ gebruiker.getTussenvoegsel() + "', ACHTERNAAM = '"
					+ gebruiker.getAchternaam() + "', ADRES = '"
					+ gebruiker.getAdres() + "', POSTCODE = '"
					+ gebruiker.getPostcode() + "', EMAIL = '"
					+ gebruiker.getEmail() + "', TELEFOONNUMMER = "
					+ gebruiker.getTelefoonnummer() + ", REKENINGNUMMER = "
					+ gebruiker.getRekeningnummer() + ", PLAATS = "
					+ gebruiker.getPlaats() + " WHERE KLANTNR = "
					+ gebruiker.getKlantnummer());
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET VOORNAAM = ?, TUSSENVOEGSEL = ?, ACHTERNAAM = ?, ADRES = ?, POSTCODE = ?, EMAIL = ?, TELEFOONNUMMER = ?, REKENINGNUMMER = ?, PLAATS = ? WHERE KLANTNR = ?");
			System.out.println(gebruiker.getVoornaam()
					+ gebruiker.getTussenvoegsel() + gebruiker.getAchternaam()
					+ gebruiker.getAdres() + gebruiker.getPostcode());
			ps.setString(1, gebruiker.getVoornaam());
			ps.setString(2, gebruiker.getTussenvoegsel());
			ps.setString(3, gebruiker.getAchternaam());
			ps.setString(4, gebruiker.getAdres());
			ps.setString(5, gebruiker.getPostcode());
			ps.setString(6, gebruiker.getEmail());
			ps.setInt(7, gebruiker.getTelefoonnummer());
			ps.setInt(8, gebruiker.getRekeningnummer());
			ps.setString(9, gebruiker.getPlaats());
			ps.setInt(10, gebruiker.getKlantnummer());

			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		} catch (SQLException e) {

			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
			return false;
		}
		GetConnection.closeConnection();
		return true;
	}

	@Override
	public void delete(Object T) {
		// TODO Auto-generated method stub

	}

	public boolean updateKrediet(int klantnr, double saldo) {
		System.out.println("Saldo: " + saldo);
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		if (connection != null) {
			System.out.println("|| Connection ready || ");
		} else {
			System.out.println("|| Connection failed ||");
		}
		try {

			System.out.println(" || Excecuting query ");
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET KREDIET = KREDIET + ? WHERE KLANTNR = ?");
			ps.setDouble(1, saldo);
			ps.setInt(2, klantnr);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();

		} catch (SQLException e) {

			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
			return false;
		}
		GetConnection.closeConnection();
		return true;

	}
	public void setWachtwoord(int klantnr, String wachtwoord)
	{
		System.out.println("wachtwoord; " + wachtwoord);
		System.out.println("klantnr; " + klantnr);
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		if (connection != null) {
			System.out.println("|| Connection ready || ");
		} else {
			System.out.println("|| Connection failed ||");
		}
		try {

			System.out.println(" || Excecuting query ");
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET WACHTWOORD = ? WHERE KLANTNR = ?");
			ps.setString(1, wachtwoord);
			ps.setInt(2, klantnr);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();

		} catch (SQLException e) {

			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
		}
		GetConnection.closeConnection();

	
	}
	public boolean betalen(int klantnr, double saldo) {
		System.out.println("Saldo: " + saldo);
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		if (connection != null) {
			System.out.println("|| Connection ready || ");
		} else {
			System.out.println("|| Connection failed ||");
		}
		try {

			System.out.println(" || Excecuting query ");
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET KREDIET = ? WHERE KLANTNR = ?");
			ps.setDouble(1, saldo);
			ps.setInt(2, klantnr);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();

		} catch (SQLException e) {

			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
			return false;
		}
		GetConnection.closeConnection();
		return true;

	}
}
