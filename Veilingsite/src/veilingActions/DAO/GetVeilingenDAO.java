package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import veilingDomain.Aanbieding;
import veilingDomain.Boek;

public class GetVeilingenDAO {
	private static String titel;
	private static String auteur;
	private static int drukken_nummer;
	private static double startprijs;
	private static Timestamp eindtijd;
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	private static ArrayList<Aanbieding> recenteveilinglijst = new ArrayList<Aanbieding>();
	public static void validate(){
		Aanbieding aanb = null;
		Boek boek = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", 
															"tho5_2013_2a_team3", "welkom_02");
				PreparedStatement ps = con.prepareStatement("SELECT startprijs, eindtijd, titel, drukken.nummer, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate");
				ResultSet rs = ps.executeQuery();
				veilingenlijst.clear();
				while (rs.next()) {
					titel = rs.getString("TITEL");
					auteur = rs.getString("AUTEUR");
					startprijs = rs.getDouble("STARTPRIJS");
					eindtijd = rs.getTimestamp("EINDTIJD");
					drukken_nummer = rs.getInt("NUMMER");
					boek = new Boek("", 0, titel, titel, titel, titel, titel, auteur, eindtijd);
					aanb = new Aanbieding(0, startprijs, eindtijd, 0,0, drukken_nummer, boek);
					veilingenlijst.add(aanb);
					System.out.println("Titel: " + titel + "|| Auteur: " +  auteur + "|| Startprijs: " +  startprijs
							+  " || Eindtijd: " + eindtijd);
					System.out.println(veilingenlijst);
				}
				PreparedStatement ps2 = con.prepareStatement("SELECT insert_date, startprijs, eindtijd, titel, drukken.nummer, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and drukken.nummer = aanbiedingen.drukken_nummer and eindtijd > sysdate and insert_date + 1 > sysdate");
				ResultSet rs2 = ps2.executeQuery();
				recenteveilinglijst.clear();
				while (rs2.next()) {
					titel = rs2.getString("TITEL");
					auteur = rs2.getString("AUTEUR");
					startprijs = rs2.getDouble("STARTPRIJS");
					eindtijd = rs2.getTimestamp("EINDTIJD");
					drukken_nummer = rs2.getInt("NUMMER");
					boek = new Boek("", 0, titel, titel, titel, titel, titel, auteur, eindtijd);
					aanb = new Aanbieding(0, startprijs, eindtijd, 0,0, drukken_nummer, boek);
					recenteveilinglijst.add(aanb);
					System.out.println("Titel: " + titel + "|| Auteur: " +  auteur + "|| Startprijs: " +  startprijs
							+  " || Eindtijd: " + eindtijd);
					System.out.println(recenteveilinglijst);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	public static String getTitel() {
		return titel;
	}

	public static void setTitel(String titel) {
		GetVeilingenDAO.titel = titel;
	}

	public static String getAuteur() {
		return auteur;
	}

	public static void setAuteur(String auteur) {
		GetVeilingenDAO.auteur = auteur;
	}

	public static double getStartprijs() {
		return startprijs;
	}

	public static void setStartprijs(double startprijs) {
		GetVeilingenDAO.startprijs = startprijs;
	}
	
	public static Timestamp getEindtijd() {
		return eindtijd;
	}

	public static void setEindtijd(Timestamp eindtijd) {
		GetVeilingenDAO.eindtijd = eindtijd;
	}

	public static ArrayList<Aanbieding> getVeilingenlijst() {
		return veilingenlijst;
	}

	public static void setVeilingenlijst(ArrayList<Aanbieding> veilingenlijst) {
		GetVeilingenDAO.veilingenlijst = veilingenlijst;
	}

	public static int getDrukken_nummer() {
		return drukken_nummer;
	}

	public static void setDrukken_nummer(int drukken_nummer) {
		GetVeilingenDAO.drukken_nummer = drukken_nummer;
	}

	public static ArrayList<Aanbieding> getRecenteveilinglijst() {
		return recenteveilinglijst;
	}

	public static void setRecenteveilinglijst(
			ArrayList<Aanbieding> recenteveilinglijst) {
		GetVeilingenDAO.recenteveilinglijst = recenteveilinglijst;
	}
	
}