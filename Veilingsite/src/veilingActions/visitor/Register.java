package veilingActions.visitor;

import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String voornaam, tussenvoegsel, achternaam, password,
			passwordCheck, email, adres, postcode, plaats;
	private int telefoonnummer, rekeningnummer;
	private Gebruiker gebruiker;

	public String execute() {
		if (!VeilingService.checkEmail(email)) {
			if (VeilingService.createGebruiker(voornaam, tussenvoegsel,
					achternaam, adres, postcode, plaats, email, password,
					telefoonnummer, rekeningnummer)) {
				gebruiker = new Gebruiker(voornaam, tussenvoegsel, achternaam,
						adres, postcode, plaats, email, password,
						telefoonnummer, rekeningnummer);
				return ActionSupport.SUCCESS;
			}
			return ActionSupport.INPUT;
		}
		addFieldError("email", "email al in gebruik");
		return ActionSupport.INPUT;
	}

	public void validate() {

		String stringTelefoonnummer = Integer.toString(telefoonnummer);
		String stringRekeningnummer = Integer.toString(rekeningnummer);
		System.out.println("|| Start register ||");
		if (voornaam.equals("")) {
			addFieldError("voornaam", "Geef je voornaam op");
		}
		if (achternaam.equals("")) {
			addFieldError("achternaam", "Geef je achternaam op");
		}
		if (postcode.equals("")) {
			addFieldError("postcode", "Geef een postcode op");
		}
		if (!postcode.equals("")
				&& !postcode.matches("^[1-9]{1}[0-9]{3} ?[A-Z]{2}$")) {
			addFieldError("postcode", "Geen juiste postcode");
		}
		if (!password.matches("^(?=.*[0-9]).{6,}$")) {
			addFieldError("password",
					"Geef een wachtwoord op met minimaal 6 tekens, 1 cijfer");
		}
		if (passwordCheck.equals("")) {
			if (password.equals(passwordCheck)) {
				addFieldError("passwordCheck",
						"Wachtwoorden komen niet overeen");
			} else {
				addFieldError("passwordCheck",
						"Geef het opgegeven wachtwoord opnieuw op");
			}
		}
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

		if (!email.matches(emailreg)) {
			addFieldError("email", "Geef een geldig e-mailadres op");
		}
		if (adres.equals("")) {
			addFieldError("adres", "Geef je adres op");
		}
		if (plaats.equals("")) {
			addFieldError("plaats", "Geef een je plaats op");
		}
		if (stringTelefoonnummer == null) {
			addFieldError("telefoonnummer", "Geef een telefoonnummer op");
		}
		if (!stringTelefoonnummer.equals("")
				&& !stringTelefoonnummer.matches("[0-9]{9}")) {
			addFieldError("telefoonnummer", "Geef een geldig telefoonnummer op");
		}
		if (stringRekeningnummer.equals("")) {
			addFieldError("rekeningnummer", "Geen geldig telefoonnummer");
		}
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
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
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getEmail() {
		return email;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPostcode(String postcode) {

		this.postcode = postcode;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public int getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public int getRekeningnummer() {
		return rekeningnummer;
	}

	public void setRekeningnummer(int rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
}