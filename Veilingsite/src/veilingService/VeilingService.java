package veilingService;

import java.sql.SQLException;
import java.util.ArrayList;

import veilingActions.DAO.*;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingDomain.Categorie;
import veilingDomain.Gebruiker;
import veilingActions.DAO.AanbiedingDAO;

public class VeilingService {
	private static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
	private static ArrayList<Categorie> categorielijst = new ArrayList<Categorie>();

	public static boolean createGebruiker(String voornaam, String tussenvoegsel,
			String achternaam, String adress, String postcode, String email,
			String password, String telefoonnummer, String rekeningnummer,
			String plaats) {

		Gebruiker gebruiker = new Gebruiker(voornaam, tussenvoegsel,
				achternaam, adress, postcode, plaats, email, password,
				Integer.parseInt(telefoonnummer),
				Integer.parseInt(rekeningnummer));
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		return gebruikerDAO.create(gebruiker);
	}

	public static Gebruiker validateUser(String email) {
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		return gebruikerDAO.retrieve(email);
	}

	public static void validateUserList() {
		UserListDAO.validate();
	}

	public static void retrieveVeilingen() {
		AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
		aanbiedingDAO.retrieve("");
	}

	public static boolean checkBoek(String isbn) {
		BoekDAO boekDAO = new BoekDAO();
		boekDAO.retrieve(isbn);

		CategorieDAO categorieDAO = new CategorieDAO();
		categorieDAO.retrieve(isbn);

		boolean b = false;
		ArrayList<Boek> boekenlijst = new ArrayList<Boek>(
				BoekDAO.getBoekenlijst());
		if (!boekenlijst.isEmpty()) {
			b = true;
		}
		return b;
	}

	public static boolean voegBoekToe(Boek boek) {

		BoekDAO boekDAO = new BoekDAO();
		return boekDAO.create(boek);
	}

	// vanaf hier getters en setters

	public static ArrayList<Gebruiker> getGebruikerslijst() {
		ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>(
				UserListDAO.getGebruikerslijst());
		return gebruikerslijst;
	}

	public static void setGebruikerslijst() {
		VeilingService.gebruikerslijst = UserListDAO.getGebruikerslijst();
	}

	public static ArrayList<Categorie> getCategorielijst() {
		ArrayList<Categorie> categorielijst = new ArrayList<Categorie>(
				CategorieDAO.getCategorielijst());
		return categorielijst;
	}

	public static void setCategorielijst() {
		VeilingService.categorielijst = CategorieDAO.getCategorielijst();
	}

	public static ArrayList<Aanbieding> getVeilingenlijst() {
		ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>(
				AanbiedingDAO.getVeilingenlijst());
		return veilingenlijst;
	}

	public static ArrayList<Aanbieding> getRecenteveilingen() {
		ArrayList<Aanbieding> recenteveilingen = new ArrayList<Aanbieding>(
				AanbiedingDAO.getRecenteveilinglijst());
		return recenteveilingen;
	}

	public static ArrayList<Boek> getBoekenlijst() {
		ArrayList<Boek> boekenlijst = new ArrayList<Boek>(
				BoekDAO.getBoekenlijst());
		return boekenlijst;
	}

}
