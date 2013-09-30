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
	private static double startprijs;
	private static Date eindtijd;
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	private static ArrayList<Boek> boekenlijst = new ArrayList<Boek>();
	
	public static Aanbieding validate(){
		Aanbieding aanb = null;
		Boek boek = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", 
															"tho5_2013_2a_team3", "welkom_02");
				PreparedStatement ps = con.prepareStatement("SELECT titel, auteur from boeken, drukken, aanbiedingen where boeken.isbn = drukken.boeken_isbn and drukken.boeken_isbn = aanbiedingen.drukken_boeken_isbn and eindtijd > sysdate");
				ResultSet rs = ps.executeQuery();
				veilingenlijst.clear();
				boekenlijst.clear();
				while (rs.next()) {
					titel = rs.getString("TITEL");
					auteur = rs.getString("AUTEUR");
					startprijs = rs.getDouble("STARTPRIJS");
					eindtijd = rs.getDate("EINDTIJD");
					aanb = new Aanbieding(0, startprijs, eindtijd, 0,0,0);
					boek = new Boek(0, 0, titel, titel, titel, titel, titel, auteur, eindtijd);
					veilingenlijst.add(aanb);
					boekenlijst.add(boek);
					System.out.println("Titel: " + titel + "|| Auteur: " +  auteur + "|| Startprijs: " +  startprijs
							+  " || Eindtijd: " + eindtijd);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return aanb;
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

	public static ArrayList<Boek> getBoekenlijst() {
		return boekenlijst;
	}

	public static void setBoekenlijst(ArrayList<Boek> boekenlijst) {
		VeilingDAO.boekenlijst = boekenlijst;
	}


}