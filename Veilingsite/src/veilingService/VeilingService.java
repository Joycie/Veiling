package veilingService;

import java.util.ArrayList;

import veilingActions.DAO.CheckIsbnDAO;
import veilingActions.DAO.LoginDAO;
import veilingActions.DAO.RegisterDAO;
import veilingActions.DAO.UserListDAO;
import veilingActions.DAO.VeilingDAO;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingDomain.Gebruiker;

public class VeilingService {
	private static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
	
	public static boolean maakuser(String voornaam, String tussenvoegsel, String achternaam, String adress, String postcode, String email, String password, String telefoonnummer, String rekeningnummer, String plaats){
		return RegisterDAO.createUser(voornaam, tussenvoegsel, achternaam,
				adress, postcode, email, password, telefoonnummer,
				rekeningnummer, plaats);
	}
	public static Gebruiker validateUser(String email, String pass){
		return LoginDAO.validate(email, pass);
	}
	public static Gebruiker validateUserList(){
		return UserListDAO.validate();
	}
	public static void validateVeiling() {
		VeilingDAO.validate();
	}
	public static boolean checkBoek(int isbn) {
		CheckIsbnDAO.zoekBoek(isbn);
		boolean b = false;
		ArrayList<Boek> boekenlijst = new ArrayList<Boek>(CheckIsbnDAO.getBoekenlijst());
		if (!boekenlijst.isEmpty()){
			b = true;
		}
		return b;
	}

	
	// vanaf hier getters en setters
	
	public static ArrayList<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}

	public static void setGebruikerslijst() {
		VeilingService.gebruikerslijst = UserListDAO.getGebruikerslijst();
	}
	public static ArrayList<Aanbieding> getVeilingenlijst() {
		ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>(VeilingDAO.getVeilingenlijst());
		return veilingenlijst;
	}
	public static ArrayList<Boek> getBoekenlijst(){
		ArrayList<Boek> boekenlijst = new ArrayList<Boek>(CheckIsbnDAO.getBoekenlijst());
		return boekenlijst;
	}

}
