package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingDomain.Boek;

public class CheckIsbnDAO {
	private static String isbn;
	private static String titel;
	private static String beschrijving;
	private static String uitgeverij;
	private static String datum;
	private static String taal;
	private static int aantalpagina;
	private static String auteur;
	private static String druk;
	private static ArrayList<Boek> boekenlijst = new ArrayList<Boek>();

	public static void zoekBoek(String isbn){
		Boek boek =null;
		setIsbn(isbn);
		try{
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection.prepareStatement("select * from boeken where isbn=" + isbn );
			ResultSet rs=ps.executeQuery();
			while (rs.next()){
				isbn = rs.getString("isbn");
				titel = rs.getString("titel");
				beschrijving = rs.getString("beschrijving");
				uitgeverij = rs.getString("uitgeverij");
				datum = rs.getString("datum");
				taal = rs.getString("taal");
				aantalpagina = rs.getInt("aantalpagina");
				auteur = rs.getString("auteur");
				System.out.println("hoi");
			}
			PreparedStatement pst = connection.prepareStatement("select * from drukken where boeken_isbn=" + isbn );
			ResultSet rst=pst.executeQuery();
			boekenlijst.clear();
			while (rst.next()){
				druk = rst.getString("nummer");
				boek = new Boek(isbn, aantalpagina, titel,druk, beschrijving, uitgeverij, taal, auteur, null);
				System.out.println(boek);
				boekenlijst.add(boek);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		GetConnection.closeConnection();
	}
	public static ArrayList<Boek> getBoekenlijst() {
		System.out.println(boekenlijst);
		return boekenlijst;
	}
	public static void setVeilingenlijst() {
		CheckIsbnDAO.boekenlijst = boekenlijst;
	}
	public static String getIsbn(){
		return isbn;
	}
	public static void setIsbn(String isbn2){
		CheckIsbnDAO.isbn = isbn2;
	}
}
