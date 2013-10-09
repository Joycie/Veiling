package veilingActions.visitor;

import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {

	private String voornaam, tussenvoegsel, achternaam, password,
			passwordCheck, email, adress, postcode, plaats, telefoonnummer,
			rekeningnummer;
	public String execute() {
		System.out.println("Test registreren");
		if (voornaam.equals("")) {
			addFieldError("voornaam", "Geef je voornaam op");
		}
		if (achternaam.equals("")) {
			addFieldError("achternaam", "Geef je achternaam op");
		}
		if (!password.matches("^(?=.*[0-9]).{6,}$"))  {
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

		if (!email.matches(emailreg))
		{
			addFieldError("email", "Geef een geldig e-mailadres op");
		}
		if (adress.equals("")) {
			addFieldError("adress", "Geef je adres op");
		}
		if (postcode.equals("")) {
			addFieldError("postcode", "Geef een geldige postcode op");
		}
		if (plaats.equals("")) {
			addFieldError("plaats", "Geef een je plaats op");
		}
		if (telefoonnummer.equals("")) {
			addFieldError("telefoonnummer", "Geef een gelig telefoonnummer op");
		}
		if (rekeningnummer.equals("")) {
			addFieldError("rekeningnummer", "Geef je rekeningnummer op");
		}
		System.out.println("test 3");
		if (hasErrors()) {
			System.out.println("test");
			return ActionSupport.INPUT;
		} else {
			if (VeilingService.maakuser(voornaam, tussenvoegsel, achternaam,
					adress, postcode, email, password, telefoonnummer,
					rekeningnummer, plaats) == true) {

				return ActionSupport.SUCCESS;
			}else {
				return ActionSupport.INPUT;
			}
		}
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