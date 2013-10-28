package veilingActions.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingInterface.VeilingInterface;

public class AanbiedingDAO implements VeilingInterface<Aanbieding> {
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	private static ArrayList<Aanbieding> recenteveilinglijst = new ArrayList<Aanbieding>();

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
					.prepareStatement("INSERT INTO AANBIEDINGEN (STARTPRIJS, EINDTIJD, GEBRUIKERS_KLANTNR, DRUKKEN_BOEKEN_ISBN, DRUKKEN_NUMMER, INSERT_DATE) VALUES(?,?,?,?,?,sysdate)");
			ps.setDouble(1, aanbieding.getStartprijs());
			ps.setTimestamp(2, aanbieding.getEindtijd());
			ps.setInt(3, aanbieding.getGebruikers_klantnr());
			ps.setString(4, aanbieding.getDrukken_isbn());
			ps.setInt(5, aanbieding.getDrukken_nummer());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public Aanbieding retrieve(String stringCategorie) {
		int categorie = Integer.parseInt(stringCategorie);
		System.out.println(categorie);
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
			
			//Geen categorie meegegeven 
			if (categorie == 0) {
				
				//Alle lopende veilingen
				PreparedStatement ps = connection
						.prepareStatement("SELECT startprijs, eindtijd, titel, datum, drukken.nummer, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate");
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
					System.out.println("Titel: " + titel + "|| Auteur: "
							+ auteur + "|| Startprijs: " + startprijs
							+ " || Eindtijd: " + eindtijd);
					System.out.println(veilingenlijst);
				}
			
				//Alle lopende veilingen aangemaakt in de laatste 24 uur
				PreparedStatement ps2 = connection
						.prepareStatement("SELECT insert_date, startprijs, eindtijd, titel, datum, drukken.nummer, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate and insert_date + 1 > sysdate");
				ResultSet rs2 = ps2.executeQuery();
				recenteveilinglijst.clear();
				while (rs2.next()) {
					String titel = rs2.getString("TITEL");
					String auteur = rs2.getString("AUTEUR");
					double startprijs = rs2.getDouble("STARTPRIJS");
					Timestamp eindtijd = rs2.getTimestamp("EINDTIJD");
					int drukken_nummer = rs2.getInt("NUMMER");
					Date datum = rs2.getDate("DATUM");
					boek = new Boek("", 0, titel, 0, titel, "", "", auteur, datum,
							0);
					aanb = new Aanbieding(0, startprijs, eindtijd, 0, "",
							drukken_nummer, boek);
					recenteveilinglijst.add(aanb);
					System.out.println("Titel: " + titel + "|| Auteur: " + auteur
							+ "|| Startprijs: " + startprijs + " || Eindtijd: "
							+ eindtijd);
					System.out.println(recenteveilinglijst);
				}
			}
			
			//Als er wel een boekcategorie is meegegeven
			else if (categorie > 0) {
				//Alle lopende veilingen
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
					System.out.println("Titel: " + titel + "|| Auteur: "
							+ auteur + "|| Startprijs: " + startprijs
							+ " || Eindtijd: " + eindtijd);
					System.out.println(veilingenlijst);
				}
			
			//Alle lopende veilingen aangemaakt in de laatste 24 uur
			PreparedStatement ps2 = connection
					.prepareStatement("SELECT insert_date, startprijs, eindtijd, titel, datum, drukken.nummer, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate and insert_date + 1 > sysdate and boeken.categorie =?");
			ps2.setInt(1, categorie);
			ResultSet rs2 = ps2.executeQuery();
			recenteveilinglijst.clear();
			while (rs2.next()) {
				String titel = rs2.getString("TITEL");
				String auteur = rs2.getString("AUTEUR");
				double startprijs = rs2.getDouble("STARTPRIJS");
				Timestamp eindtijd = rs2.getTimestamp("EINDTIJD");
				int drukken_nummer = rs2.getInt("NUMMER");
				Date datum = rs2.getDate("DATUM");
				boek = new Boek("", 0, titel, 0, titel, "", "", auteur, datum,
						0);
				aanb = new Aanbieding(0, startprijs, eindtijd, 0, "",
						drukken_nummer, boek);
				recenteveilinglijst.add(aanb);
				System.out.println("Titel: " + titel + "|| Auteur: " + auteur
						+ "|| Startprijs: " + startprijs + " || Eindtijd: "
						+ eindtijd);
				System.out.println(recenteveilinglijst);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return aanb;
	}

	@Override
	public void update(Object T) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object T) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Aanbieding> getVeilingenlijst() {
		return veilingenlijst;
	}

	public static void setVeilingenlijst(ArrayList<Aanbieding> veilingenlijst) {
		AanbiedingDAO.veilingenlijst = veilingenlijst;
	}

	public static ArrayList<Aanbieding> getRecenteveilinglijst() {
		return recenteveilinglijst;
	}

	public static void setRecenteveilinglijst(
			ArrayList<Aanbieding> recenteveilinglijst) {
		AanbiedingDAO.recenteveilinglijst = recenteveilinglijst;
	}

}
