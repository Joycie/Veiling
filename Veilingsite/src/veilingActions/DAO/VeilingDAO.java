package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import veilingDomain.Aanbieding;
import veilingDomain.Boek;

public class VeilingDAO {
	private static String titel;
	private static String auteur;
	private static int drukken_nummer;
	private static double startprijs;
	private static Date eindtijd;
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	
	public static void validate(){
		Aanbieding aanb = null;
		Boek boek = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", 
															"tho5_2013_2a_team3", "welkom_02");
				PreparedStatement ps = con.prepareStatement("SELECT startprijs, eindtijd, titel, drukken_nummer, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and eindtijd > sysdate");
				ResultSet rs = ps.executeQuery();
				veilingenlijst.clear();
				while (rs.next()) {
					titel = rs.getString("TITEL");
					auteur = rs.getString("AUTEUR");
					startprijs = rs.getDouble("STARTPRIJS");
					eindtijd = rs.getDate("EINDTIJD");
					drukken_nummer = rs.getInt("DRUKKEN_NUMMER");
					boek = new Boek(0, 0, titel, titel, titel, titel, titel, auteur, eindtijd);
					aanb = new Aanbieding(0, startprijs, eindtijd, 0,0, drukken_nummer, boek);
					veilingenlijst.add(aanb);
					System.out.println("Titel: " + titel + "|| Auteur: " +  auteur + "|| Startprijs: " +  startprijs
							+  " || Eindtijd: " + eindtijd);
					System.out.println(veilingenlijst);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	public static String getTitel() {
		return titel;
	}

	public static void setTitel(String titel) {
		VeilingDAO.titel = titel;
	}

	public static String getAuteur() {
		return auteur;
	}

	public static void setAuteur(String auteur) {
		VeilingDAO.auteur = auteur;
	}

	public static double getStartprijs() {
		return startprijs;
	}

	public static void setStartprijs(double startprijs) {
		VeilingDAO.startprijs = startprijs;
	}

	public static Date getEindtijd() {
		return eindtijd;
	}

	public static void setEindtijd(Date eindtijd) {
		VeilingDAO.eindtijd = eindtijd;
	}

	public static ArrayList<Aanbieding> getVeilingenlijst() {
		return veilingenlijst;
	}

	public static void setVeilingenlijst(ArrayList<Aanbieding> veilingenlijst) {
		VeilingDAO.veilingenlijst = veilingenlijst;
	}

	public static int getDrukken_nummer() {
		return drukken_nummer;
	}

	public static void setDrukken_nummer(int drukken_nummer) {
		VeilingDAO.drukken_nummer = drukken_nummer;
	}
	
}