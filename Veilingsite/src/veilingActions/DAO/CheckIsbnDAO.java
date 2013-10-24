package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import veilingActions.database.GetConnection;
import veilingDomain.Boek;
import veilingDomain.Categorie;

public class CheckIsbnDAO {
	private static String isbn;
	private static String titel;
	private static String beschrijving;
	private static String uitgeverij;
	private static Date datum;
	private static String taal;
	private static int aantalpagina;
	private static String auteur;
	private static int druk;
	private static int categorieboek;
	private static String naam;
	private static ArrayList<Boek> boekenlijst = new ArrayList<Boek>();
	private static ArrayList<Categorie> categorielijst = new ArrayList<Categorie>();
	
	public static void zoekBoek(String isbn){
		Boek boek = null;
		Categorie categorie = null;
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
				datum = rs.getDate("datum");
				taal = rs.getString("taal");
				aantalpagina = rs.getInt("aantalpagina");
				auteur = rs.getString("auteur");
				categorieboek = rs.getInt("categorie");
				System.out.println("hoi");
			}
			PreparedStatement ps2 = connection.prepareStatement("select * from drukken where boeken_isbn=" + isbn );
			ResultSet rs2 = ps2.executeQuery();
			boekenlijst.clear();
			while (rs2.next()){
				druk = rs2.getInt("nummer");
				boek = new Boek(isbn, aantalpagina, titel, druk, beschrijving, uitgeverij, taal, auteur, datum, categorieboek);
				System.out.println(boek);
			}
			boekenlijst.add(boek);
			
			PreparedStatement ps3 = connection.prepareStatement("select * from categorie");
			ResultSet rs3 = ps3.executeQuery();
			categorielijst.clear();
			while (rs3.next()){
				naam = rs3.getString("naam");
				categorieboek = rs3.getInt("id");
				categorie = new Categorie(categorieboek, naam); 
				categorielijst.add(categorie);
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
	public static ArrayList<Categorie> getCategorielijst() {
		return categorielijst;
	}
	public static void setCategorielijst(ArrayList<Categorie> categorielijst) {
		CheckIsbnDAO.categorielijst = categorielijst;
	}
	
}
