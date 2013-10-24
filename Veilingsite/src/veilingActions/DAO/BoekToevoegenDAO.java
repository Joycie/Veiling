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
		int categorie = boek.getCategorie();
		try{
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection.prepareStatement("INSERT INTO BOEKEN (ISBN, TITEL, BESCHRIJVING, UITGEVERIJ, DATUM, TAAL, AANTALPAGINA, AUTEUR, CATEGORIE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,isbn);
			ps.setString(2,titel);
			ps.setString(3,beschrijving);
			ps.setString(4,uitgeverij);
			ps.setDate(5,datum);
			ps.setString(6,taal);
			ps.setInt(7,aantalpagina);
			ps.setString(8,auteur);
			ps.setInt(9,categorie);
			
			ResultSet rs=ps.executeQuery();
			ps.close();
			rs.close();
			
			PreparedStatement ps2 = connection.prepareStatement("INSERT INTO DRUKKEN (BOEKEN_ISBN , NUMMER) VALUES (?, ?)" );
			ps2.setString(1,isbn);
			ps2.setInt(2, druk);
			
			ResultSet rs2 = ps2.executeQuery();
			ps2.close();
			rs2.close();
			
			PreparedStatement ps3 = connection.prepareStatement("INSERT INTO BOEKCATEGORIE (ID , BOEKEN_ISBN) VALUES (?, ?)" );
			ps3.setInt(1, categorie);
			ps3.setString(2, isbn);
			
			ResultSet rs3 = ps3.executeQuery();
			ps3.close();
			rs3.close();
			
			b = true;
		}catch(Exception e){
			e.printStackTrace();
			b = false;
		}
		GetConnection.closeConnection();
		return b;
	}

}
