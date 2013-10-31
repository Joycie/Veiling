package veilingActions.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingDomain.Boek;
import veilingDomain.Categorie;
import veilingInterface.VeilingInterface;

public class BoekDAO implements VeilingInterface<Boek> {
	private static String isbn;
	private static String titel;
	private static String beschrijving;
	private static String uitgeverij;
	private static Date datum;
	private static String taal;
	private static int aantalpagina;
	private static String auteur;
	private static int categorieboek;
	private static int druk;
	private static File img;
	private static ArrayList<Boek> boekenlijst = new ArrayList<Boek>();
	private static ArrayList<Integer> drukkenlijst = new ArrayList<Integer>();

	@Override
	public boolean create(Object T) {
		Boek boek = (Boek) T;
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		try {
			if (connection != null) {

				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO BOEKEN (ISBN, TITEL, BESCHRIJVING, UITGEVERIJ, DATUM, TAAL, AANTALPAGINA, AUTEUR, CATEGORIE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, boek.getIsbn());
			ps.setString(2, boek.getTitel());
			ps.setString(3, boek.getBeschrijving());
			ps.setString(4, boek.getUitgeverij());
			ps.setDate(5, boek.getDatum());
			ps.setString(6, boek.getTaal());
			ps.setInt(7, boek.getAantalpagina());
			ps.setString(8, boek.getAuteur());
			ps.setInt(9, boek.getCategorie());

			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();

			PreparedStatement ps2 = connection
					.prepareStatement("INSERT INTO DRUKKEN (BOEKEN_ISBN , NUMMER) VALUES (?, ?)");
			ps2.setString(1, boek.getIsbn());
			ps2.setInt(2, boek.getDruk());

			ResultSet rs2 = ps2.executeQuery();
			ps2.close();
			rs2.close();

			PreparedStatement ps3 = connection
					.prepareStatement("INSERT INTO BOEKCATEGORIE (ID , BOEKEN_ISBN) VALUES (?, ?)");
			ps3.setInt(1, boek.getCategorie());
			ps3.setString(2, boek.getIsbn());

			ResultSet rs3 = ps3.executeQuery();
			ps3.close();
			rs3.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		GetConnection.closeConnection();
		return true;

	}

	@Override
	public Boek retrieve(String ID) {

		Boek boek = null;
		Categorie categorie = null;
		Connection connection = null;
		try {
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("select * from boeken where isbn=" + ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				isbn = rs.getString("isbn");
				titel = rs.getString("titel");
				beschrijving = rs.getString("beschrijving");
				uitgeverij = rs.getString("uitgeverij");
				datum = rs.getDate("datum");
				taal = rs.getString("taal");
				aantalpagina = rs.getInt("aantalpagina");
				auteur = rs.getString("auteur");
				categorieboek = rs.getInt("categorie");
			}
			PreparedStatement ps2 = connection
					.prepareStatement("select * from drukken where boeken_isbn="
							+ ID);
			ResultSet rs2 = ps2.executeQuery();
			boekenlijst.clear();
			while (rs2.next()) {
				druk = rs2.getInt("nummer");
				boek = new Boek(isbn, aantalpagina, titel, druk, beschrijving,
						uitgeverij, taal, auteur, datum, categorieboek);
				System.out.println(boek);
			}
			boekenlijst.add(boek);

		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
		return boek;
	}

	public ArrayList<Integer> retrieveDrukken(String isbn) {
		drukkenlijst.clear();
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		try {
			if (connection != null) {

				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps2 = connection
					.prepareStatement("select * from drukken where boeken_isbn="
							+ isbn);
			ResultSet rs2 = ps2.executeQuery();
			boekenlijst.clear();
			while (rs2.next()) {
				druk = rs2.getInt("nummer");
				drukkenlijst.add(druk);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return drukkenlijst;
		}
		return drukkenlijst;
	}

	@Override
	public boolean update(Object T) {
		Boek boek = (Boek) T;
		Categorie categorie = null;
		Connection connection = null;
		try {
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps = connection
					.prepareStatement("UPDATE BOEKEN SET TITEL = ? , BESCHRIJVING = ?, UITGEVERIJ = ?, DATUM = ?, TAAL = ?, AANTALPAGINA = ?, AUTEUR = ?, CATEGORIE = ? WHERE ISBN = ?");
			ps.setString(9, boek.getIsbn());
			ps.setString(1, boek.getTitel());
			ps.setString(2, boek.getBeschrijving());
			ps.setString(3, boek.getUitgeverij());
			ps.setDate(4, boek.getDatum());
			ps.setString(5, boek.getTaal());
			ps.setInt(6, boek.getAantalpagina());
			ps.setString(7, boek.getAuteur());
			ps.setInt(8, boek.getCategorie());
			ResultSet rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}


	@Override
	public void delete(Object T) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Boek> getBoekenlijst() {
		return boekenlijst;
	}

	public static void setBoekenlijst(ArrayList<Boek> boekenlijst) {
		BoekDAO.boekenlijst = boekenlijst;
	}

}
