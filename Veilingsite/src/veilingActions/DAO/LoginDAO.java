package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import veilingDomain.Gebruiker;


public class LoginDAO {
	private static int klantnummer;
	private static String voornaam;
	private static String tussenvoegsel = "";
	private static String achternaam;
	
	public static Gebruiker validate(String email, String pass){
		boolean status=false;
		Gebruiker geb = null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", 
															"tho5_2013_2a_team3", "welkom_02");
				//PreparedStatement ps=con.prepareStatement("select * from gebruikers where email=? and wachtwoord=?");
				//
				//ps.setString(2,pass);
				PreparedStatement ps=con.prepareStatement("select * from gebruikers where email=?");
				ps.setString(1,email);
				System.out.println(email);
				
				ResultSet rs=ps.executeQuery();
				//status=rs.next();
				
				while (rs.next()) {
					if(pass.equals(rs.getString("wachtwoord"))) {
						klantnummer = rs.getInt("klantnr");
						voornaam = rs.getString("VOORNAAM");
						tussenvoegsel = rs.getString("TUSSENVOEGSEL");
						achternaam = rs.getString("ACHTERNAAM");
						geb = new Gebruiker(klantnummer, voornaam, tussenvoegsel, achternaam, "", "", "", "", "", 0, 0);
						
						System.out.println("Klantnr: " + klantnummer + " || voornaam: " +  voornaam
								+  " || tussenvoegsel: " + tussenvoegsel + " || achternaam " + achternaam);
					}
				}
				System.out.println(status);
			}catch(Exception e){
				e.printStackTrace();
			}
			return geb;
	}
}
