package veilingActions.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		int druk = boek.getDruk();
		try{
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection.prepareStatement("INSERT INTO BOEKEN (ISBN, TITEL, BESCHRIJVING, UITGEVERIJ, DATUM, TAAL, AANTALPAGINA, AUTEUR) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1,isbn);
			ps.setString(2,titel);
			ps.setString(3,beschrijving);
			ps.setString(4,uitgeverij);
			ps.setDate(5, datum);
			ps.setString(6,taal);
			ps.setInt(7,aantalpagina);
			ps.setString(8,auteur);
			
			ResultSet rs=ps.executeQuery();
			ps.close();
			rs.close();
			
			PreparedStatement pst = connection.prepareStatement("INSERT INTO DRUKKEN (BOEKEN_ISBN , NUMMER) VALUES (?, ?)" );
			pst.setString(1,isbn);
			pst.setInt(2, druk);
			
			ResultSet rst=pst.executeQuery();
			pst.close();
			rst.close();
			b = true;
		}catch(Exception e){
			e.printStackTrace();
			b = false;
		}
		GetConnection.closeConnection();
		return b;
	}

}
