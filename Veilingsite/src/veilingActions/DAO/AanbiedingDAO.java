package veilingActions.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingActions.visitor.GetAanbieding;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingDomain.Gebruiker;
import veilingInterface.VeilingInterface;
import veilingService.VeilingService;

public class AanbiedingDAO implements VeilingInterface<Aanbieding> {
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	private static ArrayList<Aanbieding> mijnveilingenlijst = new ArrayList<Aanbieding>();
	private static ArrayList<Aanbieding> recenteveilinglijst = new ArrayList<Aanbieding>();
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
					.prepareStatement("select * from boeken, aanbiedingen where aanbiedingen.id = ? and boeken.isbn = aanbiedingen.drukken_boeken_isbn");
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
				aanbieding = new Aanbieding(rs.getInt("id"),
						rs.getDouble("startprijs"),
						rs.getTimestamp("eindtijd"),
						rs.getTimestamp("insert_date"),
						rs.getInt("gebruikers_klantnr"), rs.getString("isbn"),
						rs.getInt("drukken_nummer"), boek, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aanbieding;
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
						.prepareStatement("SELECT id, insert_date, startprijs, eindtijd, titel, datum, drukken.nummer, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate");
				ResultSet rs = ps.executeQuery();
				veilingenlijst.clear();
				while (rs.next()) {
					int id = rs.getInt("id");
					String titel = rs.getString("TITEL");
					String auteur = rs.getString("AUTEUR");
					double startprijs = rs.getDouble("STARTPRIJS");
					Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
					int drukken_nummer = rs.getInt("NUMMER");
					Date datum = rs.getDate("DATUM");
					Timestamp insert_date = rs.getTimestamp("INSERT_DATE");
					boek = new Boek("", 0, titel, 0, titel, "", "", auteur,
							datum, 0);
					aanb = new Aanbieding(id, startprijs, eindtijd,
							insert_date, 0, "", drukken_nummer, boek, null);
					veilingenlijst.add(aanb);
				}
			}

			// Als er wel een boekcategorie is meegegeven
			else if (categorie > 0) {
				// Alle lopende veilingen
				PreparedStatement ps = connection
						.prepareStatement("SELECT startprijs, eindtijd, titel, datum, drukken.nummer, auteur from boeken, drukken, aanbiedingen where boeken.categorie =? and boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate");
				ps.setInt(1, categorie);
				System.out.println("Boek in categorie: " + categorie);
				ResultSet rs = ps.executeQuery();
				veilingenlijst.clear();
				while (rs.next()) {
					String titel = rs.getString("TITEL");
					String auteur = rs.getString("AUTEUR");
					double startprijs = rs.getDouble("STARTPRIJS");
					Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
					int drukken_nummer = rs.getInt("NUMMER");
					Date datum = rs.getDate("DATUM");
					boek = new Boek("", 0, titel, 0, titel, "", "", auteur,
							datum, 0);
					aanb = new Aanbieding(0, startprijs, eindtijd, 0, "",
							drukken_nummer, boek);
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
					.prepareStatement("SELECT * from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate and (LOWER(titel) like LOWER('%"
							+ invoer
							+ "%') OR LOWER(auteur) like LOWER('%"
							+ invoer + "%'))");
			ResultSet rs = ps.executeQuery();
			// ps.setString(1, invoer);
			// ps.setString(2, invoer);
			while (rs.next()) {
				// Boek
				String isbn = rs.getString("ISBN");
				int aantalpagina = rs.getInt("AANTALPAGINA");
				String titel = rs.getString("TITEL");
				String beschrijving = rs.getString("BESCHRIJVING");
				String uitgeverij = rs.getString("UITGEVERIJ");
				String taal = rs.getString("TAAL");
				String auteur = rs.getString("AUTEUR");
				Date datum = rs.getDate("DATUM");
				int categorie = rs.getInt("categorie");

				// Aanbieding
				int id = rs.getInt("id");
				double startprijs = rs.getDouble("STARTPRIJS");
				Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
				Timestamp insert_date = rs.getTimestamp("INSERT_DATE");
				int drukken_nummer = rs.getInt("NUMMER");
				int gebruikers_klantnr = rs.getInt("GEBRUIKERS_KLANTNR");
				boek = new Boek(isbn, aantalpagina, titel, 0, beschrijving,
						uitgeverij, taal, auteur, datum, categorie);
				aanb = new Aanbieding(id, startprijs, eindtijd, insert_date,
						gebruikers_klantnr, isbn, drukken_nummer, boek, null);
				gezochteveilingenlijst.add(aanb);
				System.out.println("DAO: " + gezochteveilingenlijst);
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
					.prepareStatement("SELECT * from boeken, drukken, aanbiedingen where gebruikers_klantnr = ? and boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate");
			ps.setInt(1, klantnr);
			ResultSet rs = ps.executeQuery();
			mijnveilingenlijst.clear();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String isbn = rs.getString("ISBN");
				int aantalpagina = rs.getInt("AANTALPAGINA");
				String titel = rs.getString("TITEL");
				int druk = rs.getInt("NUMMER");
				String beschrijving = rs.getString("BESCHRIJVING");
				String uitgeverij = rs.getString("BESCHRIJVING");
				String taal = rs.getString("TAAL");
				String auteur = rs.getString("AUTEUR");
				Date datum = rs.getDate("DATUM");
				int categorie = rs.getInt("CATEGORIE");
				double startprijs = rs.getDouble("STARTPRIJS");
				Timestamp eindtijd = rs.getTimestamp("EINDTIJD");
				int drukken_nummer = rs.getInt("NUMMER");
				String drukken_isbn = rs.getString("DRUKKEN_BOEKEN_ISBN");
				boek = new Boek(isbn, aantalpagina, titel, druk, beschrijving,
						uitgeverij, taal, auteur, datum, categorie);
				aanb = new Aanbieding(id, startprijs, eindtijd, klantnr,
						drukken_isbn, drukken_nummer, boek);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Object T) {
		Aanbieding aanbieding = (Aanbieding) T;
		System.out.println("v");
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("delete from aanbiedingen where id = ? and gebruikers_klantnr =?");
			ps.setInt(1, aanbieding.getId());
			ps.setInt(2, aanbieding.getGebruikers_klantnr());
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
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
