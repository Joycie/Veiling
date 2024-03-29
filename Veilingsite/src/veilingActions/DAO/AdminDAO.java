package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*         r         */
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingDomain.BiedingenStatistiek;
import veilingDomain.Gebruiker;
import veilingDomain.Statistiek;
import veilingInterface.VeilingInterface;

public class AdminDAO<T> implements VeilingInterface<T> {
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
				int klantnummer = rs.getInt("KLANTNR");
				String voornaam = rs.getString("VOORNAAM");
				String tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				String achternaam = rs.getString("ACHTERNAAM");
				String adres = rs.getString("ADRES");
				String postcode = rs.getString("POSTCODE");
				String plaats = rs.getString("PLAATS");
				String email = rs.getString("EMAIL");
				int telefoonnummer = rs.getInt("TELEFOONNUMMER");
				int rekeningnummer = rs.getInt("REKENINGNUMMER");
				double krediet = rs.getDouble("KREDIET");
				int rol = rs.getInt("ROL");

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
					.prepareStatement("SELECT * from GEBRUIKERS WHERE KLANTNR ="
							+ klantnummer);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int klantnummerDB = rs.getInt("klantnr");
				String voornaam = rs.getString("VOORNAAM");
				String tussenvoegsel = rs.getString("TUSSENVOEGSEL");
				String achternaam = rs.getString("ACHTERNAAM");
				String adres = rs.getString("ADRES");
				String postcode = rs.getString("POSTCODE");
				String plaats = rs.getString("PLAATS");
				String email = rs.getString("EMAIL");
				int telefoonnummer = rs.getInt("TELEFOONNUMMER");
				int rekeningnummer = rs.getInt("REKENINGNUMMER");
				double krediet = rs.getDouble("KREDIET");
				int rol = rs.getInt("ROL");
				gebruiker = new Gebruiker(klantnummerDB, voornaam, tussenvoegsel,
						achternaam, adres, postcode, plaats, email, "",
						telefoonnummer, rekeningnummer, krediet, rol);
			}
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return gebruiker;
	}

	public void blockUser(int klantnummer) {
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET ROL = 2 WHERE KLANTNR ="
							+ klantnummer);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}

	public void deblockUser(int klantnummer) {
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET ROL = 0 WHERE KLANTNR ="
							+ klantnummer);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();

	}

	public void giveAdmin(int klantnummer) {
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET ROL = 1 WHERE KLANTNR ="
							+ klantnummer);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
	public void takeAdmin(int klantnummer) {
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("UPDATE GEBRUIKERS SET ROL = 0 WHERE KLANTNR ="
							+ klantnummer);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
	public Statistiek retrieveStatistieken() {
		Statistiek statistiek = new Statistiek(null, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0);
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			// Aantal gebruikers ophalen
			PreparedStatement psAantalGebruikers = connection
					.prepareStatement("SELECT COUNT(*) AS AANTALGEBRUIKERS FROM GEBRUIKERS");
			ResultSet rsAantalGebruikers = psAantalGebruikers.executeQuery();
			while (rsAantalGebruikers.next()) {
				int aantalgebruikers = rsAantalGebruikers
						.getInt("AANTALGEBRUIKERS");
				statistiek.setAantalgebruikers(aantalgebruikers);
			}
			psAantalGebruikers.close();
			rsAantalGebruikers.close();

			// Totaal aantal aanbiedingen in het systeem
			PreparedStatement psTotaalAantalAanbiedingen = connection
					.prepareStatement("SELECT COUNT(*) AS TOTAALAANTALAANBIEDINGEN FROM AANBIEDINGEN");
			ResultSet rsTotaalAantalAanbiedingen = psTotaalAantalAanbiedingen
					.executeQuery();
			while (rsTotaalAantalAanbiedingen.next()) {
				int totaalaantalaanbiedingen = rsTotaalAantalAanbiedingen
						.getInt("TOTAALAANTALAANBIEDINGEN");
				statistiek
						.setTotaalaantalaanbiedingen(totaalaantalaanbiedingen);
			}
			psTotaalAantalAanbiedingen.close();
			rsTotaalAantalAanbiedingen.close();

			// Aantal lopende aanbiedingen
			PreparedStatement psAantalLopendeAanbiedingen = connection
					.prepareStatement("SELECT COUNT(*) AS AANTALLOPENDEAANBIEDINGEN FROM AANBIEDINGEN WHERE SYSDATE < EINDTIJD");
			ResultSet rsAantalLopendeAanbiedingen = psAantalLopendeAanbiedingen
					.executeQuery();
			while (rsAantalLopendeAanbiedingen.next()) {
				int aantallopendeaanbiedingen = rsAantalLopendeAanbiedingen
						.getInt("AANTALLOPENDEAANBIEDINGEN");
				statistiek
						.setAantallopendeaanbiedingen(aantallopendeaanbiedingen);
			}
			psAantalLopendeAanbiedingen.close();
			rsAantalLopendeAanbiedingen.close();

			// Aantal boeken
			PreparedStatement psAantalBoeken = connection
					.prepareStatement("SELECT COUNT(*) AS AANTALBOEKEN FROM BOEKEN");
			ResultSet rsAantalBoeken = psAantalBoeken.executeQuery();
			while (rsAantalBoeken.next()) {
				int aantalboeken = rsAantalBoeken.getInt("AANTALBOEKEN");
				statistiek.setAantalboeken(aantalboeken);
			}
			psAantalBoeken.close();
			rsAantalBoeken.close();

			// Hoogste bod van de dag
			PreparedStatement psHoogsteBodDag = connection
					.prepareStatement("SELECT MAX(BEDRAG) AS HOOGSTEBODVANDAAG FROM BIEDINGEN WHERE BIEDINGDATUM + 1 > sysdate");
			ResultSet rsHoogsteBodDag = psHoogsteBodDag.executeQuery();
			while (rsHoogsteBodDag.next()) {
				double hoogsteboddag = rsHoogsteBodDag
						.getDouble("HOOGSTEBODVANDAAG");
				statistiek.setHoogstebod_dag(hoogsteboddag);
			}
			psHoogsteBodDag.close();
			rsHoogsteBodDag.close();

			// Hoogste bod van de week
			PreparedStatement psHoogsteBodWeek = connection
					.prepareStatement("SELECT MAX(BEDRAG) AS HOOGSTEBODWEEK FROM BIEDINGEN WHERE BIEDINGDATUM + 7 > sysdate");
			ResultSet rsHoogsteBodWeek = psHoogsteBodWeek.executeQuery();
			while (rsHoogsteBodWeek.next()) {
				double hoogstebodweek = rsHoogsteBodWeek
						.getDouble("HOOGSTEBODWEEK");
				statistiek.setHoogstebod_week(hoogstebodweek);
			}
			psHoogsteBodWeek.close();
			rsHoogsteBodWeek.close();

			// Hoogste bod van de maand
			PreparedStatement psHoogsteBodMaand = connection
					.prepareStatement("SELECT MAX(BEDRAG) AS HOOGSTEBODMAAND FROM BIEDINGEN WHERE BIEDINGDATUM + 31 > sysdate");
			ResultSet rsHoogsteBodMaand = psHoogsteBodMaand.executeQuery();
			while (rsHoogsteBodMaand.next()) {
				double hoogstebodmaand = rsHoogsteBodMaand
						.getDouble("HOOGSTEBODMAAND");
				statistiek.setHoogstebod_maand(hoogstebodmaand);
			}
			psHoogsteBodMaand.close();
			rsHoogsteBodMaand.close();

			// Hoogste bod van de jaar
			PreparedStatement psHoogsteBodJaar = connection
					.prepareStatement("SELECT MAX(BEDRAG) AS HOOGSTEBODJAAR FROM BIEDINGEN WHERE BIEDINGDATUM + 365 > sysdate");
			ResultSet rsHoogsteBodJaar = psHoogsteBodJaar.executeQuery();
			while (rsHoogsteBodJaar.next()) {
				double hoogstebodjaar = rsHoogsteBodJaar
						.getDouble("HOOGSTEBODJAAR");
				statistiek.setHoogstebod_jaar(hoogstebodjaar);
			}
			psHoogsteBodJaar.close();
			rsHoogsteBodJaar.close();

			// Hoogste krediet
			PreparedStatement psHoogsteKrediet = connection
					.prepareStatement("SELECT MAX(KREDIET) AS HOOGSTEKREDIET FROM GEBRUIKERS");
			ResultSet rsHoogsteKrediet = psHoogsteKrediet.executeQuery();
			while (rsHoogsteKrediet.next()) {
				double hoogstekrediet = rsHoogsteKrediet
						.getDouble("HOOGSTEKREDIET");
				statistiek.setHoogstekrediet(hoogstekrediet);
			}
			psHoogsteKrediet.close();
			rsHoogsteKrediet.close();

			// Totale omzet
			PreparedStatement psTotaleOmzet = connection
					.prepareStatement("SELECT SUM(EINDPRIJS) AS EINDPRIJS FROM AANBIEDINGEN");
			ResultSet rsTotaleOmzet = psTotaleOmzet.executeQuery();
			while (rsTotaleOmzet.next()) {
				double totaleomzet = rsTotaleOmzet.getDouble("EINDPRIJS");
				statistiek.setTotaleomzet(totaleomzet);
			}
			psTotaleOmzet.close();
			rsTotaleOmzet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return statistiek;
	}

	public ArrayList<BiedingenStatistiek> getBiedingenStatistieken() {
		ArrayList<BiedingenStatistiek> biedingenStatistieken = new ArrayList<BiedingenStatistiek>();

		try {
			
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			// Aantal gebruikers ophalen
			PreparedStatement ps = connection
					.prepareStatement("select aanbiedingen.id, gebruikers.voornaam, gebruikers.tussenvoegsel, gebruikers.achternaam, boeken.titel, (select count(*) from biedingen where aanbiedingen_id = aanbiedingen.id)as biedingen from aanbiedingen, boeken, gebruikers where aanbiedingen.drukken_boeken_isbn = boeken.isbn and aanbiedingen.gebruikers_klantnr = gebruikers.klantnr order by biedingen desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BiedingenStatistiek BiedingenStatistiek = new BiedingenStatistiek(rs.getInt("id"), rs.getString("voornaam"), rs.getString("tussenvoegsel"), rs.getString("achternaam"), rs.getString("titel"), rs.getInt("biedingen"));
				biedingenStatistieken.add(BiedingenStatistiek);
			}
		} catch (Exception e) {
			e.printStackTrace();
			biedingenStatistieken = null;
		}
		GetConnection.closeConnection();
		return biedingenStatistieken;
	}

	// Getters & setters
	public static ArrayList<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}

	public static void setGebruikerslijst(ArrayList<Gebruiker> gebruikerslijst) {
		AdminDAO.gebruikerslijst = gebruikerslijst;
	}
	
	public static int getOpbrengst(String van, String tot) {
		int opbrengst = 0;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			// Aantal gebruikers ophalen
			PreparedStatement ps = connection
					.prepareStatement("select sum((select max(bedrag) as bedrag from biedingen where aanbiedingen_id = aanbiedingen.id))as opbrengst from aanbiedingen where eindtijd between to_date('" + van + "','dd/mm/yyyy') AND to_date('" + tot + "','dd/mm/yyyy')");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				opbrengst = rs.getInt("opbrengst");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return opbrengst;
	}

}
