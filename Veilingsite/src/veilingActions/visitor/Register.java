package veilingActions.visitor;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{
	
	private String voornaam,tussenvoegsel, achternaam,  password, email, adress, postcode, plaats,telefoonnummer, rekeningnummer;
	
	public String execute(){
		setVoornaam(voornaam);
		setAchternaam(achternaam);
		setTussenvoegsel(tussenvoegsel);
		return SUCCESS;
		
	}

	public void setVoornaam(String voornaam) {
		if (voornaam != null) {
			this.voornaam = voornaam;
			System.out.println(this.voornaam);
		}
		addFieldError("voornaam", "geen geldige waarde");

	}
	public void setTussenvoegsel(String tussenvoegsel) {
		if (tussenvoegsel != null) {
			this.tussenvoegsel = tussenvoegsel;
		}
		addFieldError("tussenvoegsel", "geen geldige waarde");

	}
	public void setAchternaam(String achternaam) {
		if (achternaam != null) {
			this.achternaam = achternaam;
		}
		addFieldError("achternaam", "geen geldige waarde");

	}


	public void setPassword(String password) {
		if (password != null) {
			this.password = password;
		}
		addFieldError("password", "geen geldige waarde");

	}

	public void checkPassword(String passwordCheck) {
		if (passwordCheck != null) {
			if (!password.equals(passwordCheck)) {

				addFieldError("passwordCheck", "wachtwoorden komen niet overeen");
			}
		}
		addFieldError("passwordCheck", "geen geldige waarde");
	}

	public void setEmail(String email) {
		if (email != null) {
			this.email = email;
		}
		addFieldError("email", "geen geldige waarde");
	}
	public void setAdress(String adress) {
		if (adress != null) {
			this.adress = adress;
		}
		addFieldError("adress", "geen geldige waarde");

	}
	public void setPostcode(String postcode) {
		if (postcode != null) {
			this.postcode = postcode;
		}
		addFieldError("postcode", "geen geldige waarde");

	}
	public void setPlaats(String plaats) {
		if (plaats != null) {
			this.plaats = plaats;
		}
		addFieldError("plaats", "geen geldige waarde");

	}
	public void setTelefoonnummer(String telefoonnummer) {
		if (telefoonnummer != null) {
			this.telefoonnummer = telefoonnummer;
		}
		addFieldError("telefoonnummer", "geen geldige waarde");

	}
	public void setRekeningnummer(String rekeningnummer) {
		if (rekeningnummer != null) {
			this.rekeningnummer = rekeningnummer;
		}
		addFieldError("rekeningnummer", "geen geldige waarde");

	}

}