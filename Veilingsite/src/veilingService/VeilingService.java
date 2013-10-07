package veilingService;

import java.util.ArrayList;

import veilingActions.DAO.LoginDAO;
import veilingActions.DAO.RegisterDAO;
import veilingActions.DAO.UserListDAO;
import veilingActions.DAO.VeilingDAO;
import veilingDomain.Aanbieding;
import veilingDomain.Gebruiker;

public class VeilingService {
	private static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
	private static ArrayList<Aanbieding> veilingenlijst = new ArrayList<Aanbieding>();
	
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
	public static Aanbieding validateVeiling() {
		return VeilingDAO.validate();
	}

	
	// vanaf hier getters en setters
	
	public static ArrayList<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}

	public static void setGebruikerslijst(ArrayList<Gebruiker> gebruikerslijst) {
		VeilingService.gebruikerslijst = UserListDAO.getGebruikerslijst();
	}
	public static ArrayList<Aanbieding> getVeilingenlijst() {
		return veilingenlijst;
	}

	public static void setVeilingenlijst(ArrayList<Aanbieding> veilingenlijst) {
		VeilingService.veilingenlijst = VeilingDAO.getVeilingenlijst();
	}

}
