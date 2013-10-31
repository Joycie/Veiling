package veilingService;

import java.sql.SQLException;
import java.util.ArrayList;

import veilingActions.DAO.*;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingDomain.Categorie;
import veilingDomain.Gebruiker;
import veilingDomain.Statistiek;
import veilingActions.DAO.AanbiedingDAO;

public class VeilingService {
	private static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
	private static ArrayList<Categorie> categorielijst = new ArrayList<Categorie>();

	public static boolean createGebruiker(String voornaam,
			String tussenvoegsel, String achternaam, String adres,
			String postcode, String plaats, String email, String password,
			int telefoonnummer, int rekeningnummer) {

		Gebruiker gebruiker = new Gebruiker(voornaam, tussenvoegsel,
				achternaam, adres, postcode, plaats, email, password,
				telefoonnummer, rekeningnummer);
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		return gebruikerDAO.create(gebruiker);
	}

	public static boolean updateGebruiker(String voornaam,
			String tussenvoegsel, String achternaam, String adres,
			String postcode, String plaats, String email, int telefoonnummer,
			int rekeningnummer, int klantnr) {
		Gebruiker gebruiker = new Gebruiker(klantnr, voornaam, tussenvoegsel,
				achternaam, adres, postcode, plaats, email, telefoonnummer,
				rekeningnummer);
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		return gebruikerDAO.update(gebruiker);
	}

	public static boolean updateKrediet(int klantnr, double saldo) {
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		return gebruikerDAO.updateKrediet(klantnr, saldo);

	}

	public static Gebruiker validateUser(String email) {
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		return gebruikerDAO.retrieve(email);
	}

	public static Gebruiker validateUserList(String ID) {
		AdminDAO adminDAO = new AdminDAO();
		return (Gebruiker) adminDAO.retrieve(ID);
	}

	public static Gebruiker retrieveUser(int klantnummer) {
		AdminDAO adminDAO = new AdminDAO();
		return adminDAO.retrieveUser(klantnummer);
	}

	public static void blockUser(int klantnummer) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.blockUser(klantnummer);
	}

	public static void deblockUser(int klantnummer) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.deblockUser(klantnummer);
	}
	public static void giveAdmin(int klantnummer) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.giveAdmin(klantnummer);
	}
	public static void takeAdmin(int klantnummer) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.takeAdmin(klantnummer);
	}
	public static void retrieveVeilingen(String categorie) {
		AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
		aanbiedingDAO.retrieve(categorie);
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

	public static boolean voegVeilingToe(Aanbieding aanbieding) {
		AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
		return aanbiedingDAO.create(aanbieding);
	}

	public static boolean checkEmail(String email) {
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		ArrayList<String> alle_emails = gebruikerDAO.retrieveEmail();
		if (!alle_emails.isEmpty()) {
			for (int i = 0; i < alle_emails.size(); i++) {
				if (email.equals(alle_emails.get(i))) {
					return true;
				}
			}
		}
		return false;
	}

	public static void deleteAanbieding(Aanbieding aanbieding) {
		AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
		aanbiedingDAO.delete(aanbieding);

	}

	public static boolean BoekWijzigen(Boek boek) {
		BoekDAO boekDAO = new BoekDAO();
		return boekDAO.update(boek);
	}
	public static Statistiek retrieveStatistieken() {
		AdminDAO adminDAO = new AdminDAO();
		return adminDAO.retrieveStatistieken();
	}
	public static boolean aanbiedingWijzigen(Aanbieding aanbieding) {
		AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
		return aanbiedingDAO.update(aanbieding);
	}
	// vanaf hier getters en setters

	public static ArrayList<Gebruiker> getGebruikerslijst() {
		ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>(
				AdminDAO.getGebruikerslijst());
		return gebruikerslijst;
	}
		
	public static Gebruiker getGebruiker(int klantnr) {
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		return gebruikerDAO.retrieveById(klantnr);
	}

	public static void setGebruikerslijst() {
		VeilingService.gebruikerslijst = AdminDAO.getGebruikerslijst();
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

	public static Boek getBoek(String isbn) {
		BoekDAO boekDAO = new BoekDAO();
		return boekDAO.retrieve(isbn);
	}

	public static boolean checkDruk(String isbn, int nummer) {
		BoekDAO boekDAO = new BoekDAO();
		ArrayList<Integer> drukkenlijst = boekDAO.retrieveDrukken(isbn);
		if (!drukkenlijst.isEmpty()) {
			for (int i = 0; i < drukkenlijst.size(); i++) {
				if (nummer == drukkenlijst.get(i)) {
					return true;
				}
			}
		}
		return false;
	}

	public static ArrayList<Aanbieding> getMijnveilingen(int klantnr) {
		AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
		return aanbiedingDAO.retrieveMijnVeilingen(klantnr);
	}

	public static Aanbieding getAanbieding(int id) {
		AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
		return aanbiedingDAO.getAanbieding(id);
	}

}
