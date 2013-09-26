package veilingActions.visitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import veilingActions.database.DatabaseQuery;

import com.opensymphony.xwork2.ActionSupport;


public class Register extends ActionSupport {

	private String voornaam, tussenvoegsel, achternaam, password,
			passwordCheck, email, adress, postcode, plaats, telefoonnummer, rekeningnummer;
	private DatabaseQuery DBT;

	public String execute() {
		System.out.println("Test registreren");
		if (voornaam.equals("")) {
			addFieldError("voornaam", "geen geldige waarde");
		}
		if (achternaam.equals("")) {
			addFieldError("achternaam", "geen geldige waarde");
		}
		if (password.equals("")) {
			addFieldError("password", "geen geldige waarde");
		}
		if (passwordCheck.equals("")) {
			if (password.equals(passwordCheck)) {
				addFieldError("passwordCheck", "wachtwoorden komen niet overeen");
			}
			addFieldError("passwordCheck", "geen geldige waarde");
		}
		if (email.equals("")) {
			addFieldError("email", "geen geldige waarde");
		}
		if (adress.equals("")) {
			addFieldError("adress", "geen geldige waarde");
		}
		if (postcode.equals("")) {
			addFieldError("postcode", "geen geldige waarde");
		}
		if (plaats.equals("")) {
			addFieldError("plaats", "geen geldige waarde");
		}
		if (telefoonnummer.equals("")) {
			addFieldError("telefoonnummer", "geen geldige waarde");
		}
		if (rekeningnummer.equals("")) {
			addFieldError("rekeningnummer", "geen geldige waarde");
		}
		System.out.println("test 3");
		if (hasErrors()){
			System.out.println("test");
			return ActionSupport.INPUT;
		}else{
			Connection connection = null;
			try {
				DBT.getDBConnection();
				connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl",
						"tho5_2013_2a_team3", "welkom_02");
				if (connection != null) {
					System.out.println("Connectie geslaagd");
				} else {
					System.out.println("Mislukt");
				}

			} catch (SQLException e) {

				System.out.println("Connectie mislukt!");
				e.printStackTrace();
			}
			System.out.println("Opvragen van email + wachtwoord: ");
			DatabaseQuery.insertRecordsToDbUserTable("INSERT INTO GEBRUIKERS (VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM, ADRES, POSTCODE, EMAIL, WACHTWOORD, TELEFOONNUMMER, REKENINGNUMMER, PLAATS) VALUES ('"+voornaam +"', '"+tussenvoegsel+"', '"+achternaam+"', '"+adress+"', '"+postcode+"', '"+email+"', '"+password+"', '"+telefoonnummer+"', '"+rekeningnummer+"', '"+plaats+"')");
			
		
		return ActionSupport.SUCCESS;}
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
		System.out.println(this.voornaam);

	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;

	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
		System.out.println(passwordCheck);
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public void setAdress(String adress) {

		this.adress = adress;

	}

	public void setPostcode(String postcode) {

		this.postcode = postcode;

	}

	public void setPlaats(String plaats) {

		this.plaats = plaats;

	}

	public void setTelefoonnummer(String telefoonnummer) {

		this.telefoonnummer = telefoonnummer;

	}

	public void setRekeningnummer(String rekeningnummer) {

		this.rekeningnummer = rekeningnummer;

	}

}