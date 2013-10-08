package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import veilingActions.database.DatabaseQuery;
import veilingDomain.Boek;

public class CheckIsbnDAO {
	private static int isbn;
	private static String titel;
	private static String beschrijving;
	private static String uitgeverij;
	private static String datum;
	private static String taal;
	private static int aantalpagina;
	private static String auteur;
	private static String druk;
	private static ArrayList<Boek> boekenlijst = new ArrayList<Boek>();

	public static void zoekBoek(int isbn){
		Boek boek =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DatabaseQuery.getDBConnection();
			PreparedStatement ps=con.prepareStatement("select * from boeken where isbn=" + isbn );
			ResultSet rs=ps.executeQuery();
			while (rs.next()){
				isbn = rs.getInt("isbn");
				titel = rs.getString("titel");
				beschrijving = rs.getString("beschrijving");
				uitgeverij = rs.getString("uitgeverij");
				datum = rs.getString("datum");
				taal = rs.getString("taal");
				aantalpagina = rs.getInt("aantalpagina");
				auteur = rs.getString("auteur");
				System.out.println("hoi");
			}
			PreparedStatement pst=con.prepareStatement("select * from drukken where boeken_isbn=" + isbn );
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
		
		
	}
	public static ArrayList<Boek> getBoekenlijst() {
		System.out.println(boekenlijst);
		return boekenlijst;
	}
	public static void setVeilingenlijst() {
		CheckIsbnDAO.boekenlijst = boekenlijst;
	}
}
