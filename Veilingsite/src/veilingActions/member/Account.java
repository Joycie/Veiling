package veilingActions.member;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import veilingDomain.Boek;
import veilingDomain.Gebruiker;

import com.opensymphony.xwork2.ActionSupport;

public class Account extends ActionSupport implements SessionAware {
	private SessionMap session;
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String adres;
	private String postcode;
	private String plaats;
	private String email;
	private String wachtwoord;
	private String rewachtwoord;
	private String telefoonnummer;
	private String rekeningnummer;
	
	public String execute(){
		return SUCCESS;
	}
	
	public void validate() {
		if(voornaam.equals(""))
			addFieldError("voornaam", "Geef je voornaam op");
		if(achternaam.equals(""))
			addFieldError("achtenraam", "Geef je achternaam op");
		if(voornaam.equals(""))
			addFieldError("voornaam", "Geef je naam op");
		if(!postcode.equals("") && !postcode.matches("^[1-9]{1}[0-9]{3} ?[A-Z]{2}$"))
			addFieldError("postcode", "Geef een geldige postcode op");
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
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

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public void setRewachtwoord(String rewachtwoord) {
		this.rewachtwoord = rewachtwoord;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}
}
