package veilingActions.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import veilingActions.database.GetConnection;
import veilingActions.visitor.GetAanbieding;
import veilingDomain.Aanbieding;
import veilingDomain.Bod;
import veilingDomain.Boek;
import veilingDomain.Gebruiker;
import veilingInterface.VeilingInterface;
import veilingService.VeilingService;

public class AanbiedingDAO implements VeilingInterface<Aanbieding> {
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	private static ArrayList<Aanbieding> mijnveilingenlijst = new ArrayList<Aanbieding>();
	private static ArrayList<Aanbieding> gezochteveilingenlijst = new ArrayList<Aanbieding>();

	@Override
	public boolean create(Object T) {
		Aanbieding aanbieding = (Aanbieding) T;
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		try {
			if (connection != null) {

				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO AANBIEDINGEN (STARTPRIJS, EINDTIJD, GEBRUIKERS_KLANTNR, DRUKKEN_BOEKEN_ISBN, DRUKKEN_NUMMER, INSERT_DATE, IMAGE) VALUES(?,?,?,?,?,sysdate, ?)");
			ps.setDouble(1, aanbieding.getStartprijs());
			ps.setTimestamp(2, aanbieding.getEindtijd());
			ps.setInt(3, aanbieding.getGebruikers_klantnr());
			ps.setString(4, aanbieding.getDrukken_isbn());
			ps.setInt(5, aanbieding.getDrukken_nummer());
			ps.setBytes(6, aanbieding.getImg());
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
			if (!VeilingService.checkDruk(aanbieding.getDrukken_isbn(),
					aanbieding.getDrukken_nummer())) {
				PreparedStatement ps2 = connection
						.prepareStatement("INSERT INTO DRUKKEN (BOEKEN_ISBN, NUMMER) VALUES (?, ?)");
				ps2.setString(1, aanbieding.getDrukken_isbn());
				ps2.setInt(2, aanbieding.getDrukken_nummer());
				ResultSet rs2 = ps2.executeQuery();
				rs2.close();
				ps2.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		GetConnection.closeConnection();
		return true;

	}

	public Aanbieding getAanbieding(int id) {
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		Aanbieding aanbieding = null;
		try {
			PreparedStatement ps = connection
					.prepareStatement("select boeken.*, aanbiedingen.*, (select max(bedrag) from biedingen where biedingen.aanbiedingen_id = aanbiedingen.id) as bedrag from boeken, aanbiedingen where aanbiedingen.id = ? and eindtijd > sysdate and aanbiedingen.drukken_boeken_isbn = boeken.isbn and rownum <= 1");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Boek boek = new Boek(rs.getString("isbn"),
						rs.getInt("aantalpagina"), rs.getString("titel"),
						rs.getInt("drukken_nummer"),
						rs.getString("beschrijving"),
						rs.getString("uitgeverij"), rs.getString("taal"),
						rs.getString("auteur"), rs.getDate("datum"),
						rs.getInt("categorie"));
				// int gebruiker = new Gebruiker(0, null, null, null, null,
				// null, null, null, 0, 0);
				Bod bod = new Bod (null, 0, 0, rs.getDouble("BEDRAG"));
				aanbieding = new Aanbieding(rs.getInt("id"),
						rs.getDouble("startprijs"),
						rs.getTimestamp("eindtijd"),
						rs.getTimestamp("insert_date"),
						rs.getInt("gebruikers_klantnr"), rs.getString("isbn"),
						rs.getInt("drukken_nummer"), boek, bod, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aanbieding;
	}

	public ArrayList<Bod> getBiedingen(int id) {
		ArrayList<Bod> biedingen = new ArrayList<Bod>();
		Bod bod = null;
		Gebruiker gebruiker = null;
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from gebruikers, biedingen where gebruikers.klantnr = biedingen.gebruiker_klantnr and biedingen.aanbiedingen_id=? order by bedrag desc");
			ps.setInt(1, id);
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

				gebruiker = new Gebruiker(klantnummer, voornaam, tussenvoegsel,
						achternaam, adres, postcode, plaats, email, wachtwoord,
						telefoonnummer, rekeningnummer, krediet, rol);
				bod = new Bod(rs.getTimestamp("biedingdatum"),
						rs.getInt("gebruiker_klantnr"),
						rs.getInt("aanbiedingen_id"), rs.getInt("bedrag"),
						gebruiker);
				biedingen.add(bod);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return biedingen;
	}

	@Override
	public Aanbieding retrieve(String stringCategorie) {
		int categorie = Integer.parseInt(stringCategorie);
		Aanbieding aanb = null;
		Boek boek = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}

			// Geen categorie meegegeven
			if (categorie == 0) {

				// Alle lopende veilingen
				PreparedStatement ps = connection
						.prepareStatement("select (select max(bedrag) from biedingen where biedingen.aanbiedingen_id = aanbiedingen.id)"
								+ "as bedrag, aanbiedingen.*, boeken.* from aanbiedingen, boeken where eindtijd > sysdate and aanbiedingen.drukken_boeken_isbn = boeken.isbn order by eindtijd asc");
				ResultSet rs = ps.executeQuery();
				veilingenlijst.clear();
				while (rs.next()) {
					double bedrag = rs.getDouble("BEDRAG");
					int id = rs.getInt("id");
					String titel = rs.getString("TITEL");
					String auteur = rs.getString("AUTEUR");
					double startprijs = rs.getDouble("STARTPRIJS");
					Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
					int drukken_nummer = rs.getInt("drukken_nummer");
					Date datum = rs.getDate("DATUM");
					int gebruikers_klantnr = rs.getInt("GEBRUIKERS_KLANTNR");
					Timestamp insert_date = rs.getTimestamp("INSERT_DATE");
					boek = new Boek("", 0, titel, 0, titel, "", "", auteur,
							datum, 0);
					Bod bod = new Bod(null, 0, id, bedrag);
					aanb = new Aanbieding(id, startprijs, eindtijd,
							insert_date, gebruikers_klantnr, "",
							drukken_nummer, boek, bod, null);
					veilingenlijst.add(aanb);

				}
				PreparedStatement ps2 = connection
						.prepareStatement("select * from gebruikers, boeken, aanbiedingen where eindtijd < sysdate and isgemaild = 0 and gebruikers.klantnr = aanbiedingen.gebruikers_klantnr and boeken.isbn = aanbiedingen.drukken_boeken_isbn");
				ResultSet rs2 = ps2.executeQuery();

				while (rs2.next()) {
					// Eigenaar van aanbieding
					String voornaamEigenaaraanbieding = rs2
							.getString("voornaam");
					String tussenvoegselEigenaaraanbieding = rs2
							.getString("tussenvoegsel");
					String achternaamEigenaaraanbieding = rs2
							.getString("achternaam");
					String emailEigenaaraanbieding = rs2.getString("email");
					String titelBoek = rs2.getString("titel");
					
					String tussenvoegsel = "";
					if (tussenvoegselEigenaaraanbieding != null)
					{
						tussenvoegsel = tussenvoegselEigenaaraanbieding + " ";
					}
					try {
						Properties props = new Properties();
						props.put("mail.smtp.host", "smtp.gmail.com");
						props.put("mail.smtp.port", 465);
						props.put("mail.smtp.ssl.enable", true);
						Session mailSession = Session.getInstance(props);
						MimeMessage msg = new MimeMessage(mailSession);
						msg.setFrom(new InternetAddress(
								"multatuliveiling@gmail.com",
								"Multatuli Veilingen"));
						msg.setRecipients(Message.RecipientType.TO,
								emailEigenaaraanbieding);
						msg.setSubject("Uw aanbieding is afgelopen");
						msg.setSentDate(Calendar.getInstance().getTime());
						msg.setText("Beste " + voornaamEigenaaraanbieding + " "
								+ tussenvoegsel
								+ achternaamEigenaaraanbieding
								+ ", Uw veiling van het boek \n \n Titel: "
								+ titelBoek + " is afgelopen ");
						Transport.send(msg, "multatuliveiling@gmail.com",
								"register_3");
						System.out.println("Mail verstuurd naar aanbieder");
					} catch (Exception e) {

					}
					
				}

				PreparedStatement ps3 = connection
						.prepareStatement("select aanbiedingen.eindprijs, gebruikers.*, biedingen.*, boeken.* from boeken, biedingen, gebruikers, aanbiedingen where eindtijd < sysdate and isgemaild = 0 and eindprijs = biedingen.bedrag and gebruikers.klantnr = biedingen.gebruiker_klantnr and aanbiedingen.drukken_boeken_isbn = boeken.isbn ");
				ResultSet rs3 = ps3.executeQuery();

				while (rs3.next()) {
					// Winnaar
					String voornaamWinnaar = rs3
							.getString("voornaam");
					String tussenvoegselWinnaar = rs3
							.getString("tussenvoegsel");
					String achternaamWinnaar = rs3
							.getString("achternaam");
					String emailWinnaar = rs3.getString("email");
					String titelBoek = rs3.getString("titel");
					String auteurBoek = rs3.getString("auteur");
					double eindprijs = rs3.getDouble("eindprijs");
					
					String tussenvoegsel = "";
					if (tussenvoegselWinnaar != null)
					{
						tussenvoegsel = tussenvoegselWinnaar + " ";
					}
					try {
						Properties props = new Properties();
						props.put("mail.smtp.host", "smtp.gmail.com");
						props.put("mail.smtp.port", 465);
						props.put("mail.smtp.ssl.enable", true);
						Session mailSession = Session.getInstance(props);
						MimeMessage msg = new MimeMessage(mailSession);
						msg.setFrom(new InternetAddress(
								"multatuliveiling@gmail.com",
								"Multatuli Veilingen"));
						msg.setRecipients(Message.RecipientType.TO,
								emailWinnaar);
						msg.setSubject("U heeft een veiling gewonnen");
						msg.setSentDate(Calendar.getInstance().getTime());
						msg.setText("Beste " + voornaamWinnaar + " "
								+ tussenvoegsel
								+ achternaamWinnaar
								+ ", U heeft een veiling gewonnen! \n \n Titel: "
								+ titelBoek + " \n Auteur: " + auteurBoek
								+ "\n\n Met het winnende bod van: " + eindprijs + " ! \n GEFELICITEERD!!");
						Transport.send(msg, "multatuliveiling@gmail.com",
								"register_3");
						System.out.println("Mail verstuurd naar winnaar");
					} catch (Exception e) {

					}
	
				}
				PreparedStatement ps4 = connection
						.prepareStatement("update aanbiedingen set isgemaild = 1 where eindtijd < sysdate");
				ResultSet rs4 = ps4.executeQuery();
				ps.close();
				rs.close();
				ps2.close();
				rs2.close();
				ps3.close();
				rs3.close();
				ps4.close();
				rs4.close();
			}

			// Als er wel een boekcategorie is meegegeven
			else if (categorie > 0) {
				// Alle lopende veilingen
				PreparedStatement ps = connection
						.prepareStatement("select (select max(bedrag) from biedingen where biedingen.aanbiedingen_id = aanbiedingen.id)"
								+ "as bedrag, aanbiedingen.*, boeken.* from aanbiedingen, boeken where eindtijd > sysdate and aanbiedingen.drukken_boeken_isbn = boeken.isbn and categorie=? order by eindtijd asc");
				ps.setInt(1, categorie);
				System.out.println("Boek in categorie: " + categorie);
				ResultSet rs = ps.executeQuery();
				veilingenlijst.clear();
				while (rs.next()) {
					double bedrag = rs.getDouble("BEDRAG");
					int id = rs.getInt("id");
					String titel = rs.getString("TITEL");
					String auteur = rs.getString("AUTEUR");
					double startprijs = rs.getDouble("STARTPRIJS");
					Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
					int drukken_nummer = rs.getInt("drukken_nummer");
					Date datum = rs.getDate("DATUM");
					int gebruikers_klantnr = rs.getInt("GEBRUIKERS_KLANTNR");
					Timestamp insert_date = rs.getTimestamp("INSERT_DATE");
					boek = new Boek("", 0, titel, 0, titel, "", "", auteur,
							datum, 0);
					Bod bod = new Bod(null, 0, id, bedrag);
					aanb = new Aanbieding(id, startprijs, eindtijd,
							insert_date, gebruikers_klantnr, "",
							drukken_nummer, boek, bod, null);
					veilingenlijst.add(aanb);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return aanb;
	}

	public double getLaatsteBieding(int id) {
		double eindprijs = 0;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("SELECT EINDPRIJS from AANBIEDINGEN where ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				eindprijs = rs.getDouble("EINDPRIJS");
			}
			return eindprijs;
		} catch (Exception e) {
			e.printStackTrace();
			return eindprijs;
		}
	}

	public ArrayList<Aanbieding> searchVeilingen(String invoer) {
		gezochteveilingenlijst.clear();
		System.out.println("Invoer: " + invoer);
		Aanbieding aanb = null;
		Boek boek = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			// Alle lopende veilingen
			PreparedStatement ps = connection
					.prepareStatement("select (select max(bedrag) from biedingen where biedingen.aanbiedingen_id = aanbiedingen.id)"
							+ "as bedrag, aanbiedingen.*, boeken.* from aanbiedingen, boeken where eindtijd > sysdate and aanbiedingen.drukken_boeken_isbn = boeken.isbn and (LOWER(titel) like LOWER('%"
							+ invoer
							+ "%') OR LOWER(auteur) like LOWER('%"
							+ invoer + "%'))");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// Boek
				double bedrag = rs.getDouble("BEDRAG");
				int id = rs.getInt("id");
				String titel = rs.getString("TITEL");
				String auteur = rs.getString("AUTEUR");
				double startprijs = rs.getDouble("STARTPRIJS");
				Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
				int drukken_nummer = rs.getInt("drukken_nummer");
				Date datum = rs.getDate("DATUM");
				int gebruikers_klantnr = rs.getInt("GEBRUIKERS_KLANTNR");
				Timestamp insert_date = rs.getTimestamp("INSERT_DATE");
				boek = new Boek("", 0, titel, 0, titel, "", "", auteur, datum,
						0);
				Bod bod = new Bod(null, 0, id, bedrag);
				aanb = new Aanbieding(id, startprijs, eindtijd, insert_date,
						gebruikers_klantnr, "", drukken_nummer, boek, bod, null);
				gezochteveilingenlijst.add(aanb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return gezochteveilingenlijst;

	}

	public ArrayList<Aanbieding> retrieveMijnVeilingen(int klantnr) {
		Aanbieding aanb = null;
		Boek boek = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}

			PreparedStatement ps = connection
					.prepareStatement("select (select max(bedrag) from biedingen where biedingen.aanbiedingen_id = aanbiedingen.id)"
							+ "as bedrag, aanbiedingen.*, boeken.* from aanbiedingen, boeken where eindtijd > sysdate and aanbiedingen.drukken_boeken_isbn = boeken.isbn and gebruikers_klantnr =?");
			ps.setInt(1, klantnr);
			ResultSet rs = ps.executeQuery();
			mijnveilingenlijst.clear();
			while (rs.next()) {
				double bedrag = rs.getDouble("BEDRAG");
				int id = rs.getInt("ID");
				String isbn = rs.getString("ISBN");
				int aantalpagina = rs.getInt("AANTALPAGINA");
				String titel = rs.getString("TITEL");
				int druk = rs.getInt("DRUKKEN_NUMMER");
				String beschrijving = rs.getString("BESCHRIJVING");
				String uitgeverij = rs.getString("BESCHRIJVING");
				String taal = rs.getString("TAAL");
				String auteur = rs.getString("AUTEUR");
				Date datum = rs.getDate("DATUM");
				int categorie = rs.getInt("CATEGORIE");
				Timestamp insert_date = rs.getTimestamp("INSERT_DATE");
				double startprijs = rs.getDouble("STARTPRIJS");
				Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
				int drukken_nummer = rs.getInt("DRUKKEN_NUMMER");
				boek = new Boek(isbn, aantalpagina, titel, druk, beschrijving,
						uitgeverij, taal, auteur, datum, categorie);
				Bod bod = new Bod(null, 0, id, bedrag);
				aanb = new Aanbieding(id, startprijs, eindtijd, insert_date,
						klantnr, "", drukken_nummer, boek, bod, null);
				mijnveilingenlijst.add(aanb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return mijnveilingenlijst;
	}

	@Override
	public boolean update(Object T) {
		Aanbieding aanbieding = (Aanbieding) T;

		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("update aanbiedingen set eindtijd = ? where id = ?");
			ps.setTimestamp(1, aanbieding.getEindtijd());
			ps.setInt(2, aanbieding.getId());
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();

		return false;
	}

	@Override
	public void delete(Object T) {
		Aanbieding aanbieding = (Aanbieding) T;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			if (aanbieding.getGebruikers_klantnr() == 0) {

				PreparedStatement ps = connection
						.prepareStatement("delete from biedingen where aanbiedingen_id = ?");
				ps.setInt(1, aanbieding.getId());
				ResultSet rs = ps.executeQuery();
				rs.close();
				ps.close();

				PreparedStatement ps2 = connection
						.prepareStatement("delete from aanbiedingen where id = ?");
				ps2.setInt(1, aanbieding.getId());
				ResultSet rs2 = ps2.executeQuery();
				rs2.close();
				ps2.close();

			} else {
				PreparedStatement ps3 = connection
						.prepareStatement("delete from aanbiedingen where id = ? and gebruikers_klantnr =?");
				ps3.setInt(1, aanbieding.getId());
				ps3.setInt(2, aanbieding.getGebruikers_klantnr());
				ResultSet rs3 = ps3.executeQuery();
				rs3.close();
				ps3.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}

	public static ArrayList<Aanbieding> getVeilingenlijst() {
		return veilingenlijst;
	}

	public static void setVeilingenlijst(ArrayList<Aanbieding> veilingenlijst) {
		AanbiedingDAO.veilingenlijst = veilingenlijst;
	}

	public static GetAanbieding findById(String veilingid) {
		// TODO Auto-generated method stub
		return null;
	}

}
