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

public class VeilingDAO {
	private static int id;
	private static double startprijs;
	private static Date eindtijd;
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	
	public static Aanbieding validate(){
		boolean status=false;
		Aanbieding aanb = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", 
															"tho5_2013_2a_team3", "welkom_02");
				PreparedStatement ps = con.prepareStatement("SELECT ID, STARTPRIJS, EINDTIJD from AANBIEDINGEN");
				System.out.println(id + " " + startprijs + " " +  eindtijd);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					id = rs.getInt("id");
					startprijs = rs.getDouble("startprijs");
					eindtijd = rs.getDate("eindtijd");
					aanb = new Aanbieding(id, startprijs, eindtijd, 0,0,0);
					veilingenlijst.add(aanb);
					System.out.println("ID: " + id + " || Startprijs: " +  startprijs
							+  " || eindtijd: " + eindtijd);
				}
				System.out.println(status);
			}catch(Exception e){
				e.printStackTrace();
			}
			return aanb;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		VeilingDAO.id = id;
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
		
}