package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import veilingActions.database.GetConnection;
import veilingDomain.Boek;

public class BoekToevoegenDAO {

	public static boolean VoegBoekToe(Boek boek) {
		boolean b = false;
		String isbn = boek.getIsbn();
		String titel = boek.getTitel();
		String beschrijving = boek.getBeschrijving();
		String uitgeverij = boek.getUitgeverij();
		Date datum = boek.getDatum();
		String taal = boek.getTaal();
		int aantalpagina = boek.getAantalpagina();
		String auteur = boek.getAuteur();
		String druk = boek.getDruk();
		try{
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection.prepareStatement("INSERT INTO BOEKEN (ISBN, TITEL, BESCHRIJVING, UITGEVERIJ, DATUM, TAAL, AANTALPAGINA, AUTEUR) VALUES ('"+isbn +"', '"+titel+"', '"+beschrijving+"', '"+uitgeverij+"', '"+datum+"', '"+taal+"', '"+aantalpagina+"', '"+auteur+"')");
			ResultSet rs=ps.executeQuery();
			PreparedStatement pst = connection.prepareStatement("INSERT INTO DRUKKEN (BOEKEN_ISBN , NUMMER) VALUES ('" + isbn + "', '" + druk + "')" );
			ResultSet rst=pst.executeQuery();
			b = true;
		}catch(Exception e){
			e.printStackTrace();
			b = false;
		}
		GetConnection.closeConnection();
		return b;
	}

}
