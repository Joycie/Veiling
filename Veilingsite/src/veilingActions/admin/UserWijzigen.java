package veilingActions.admin;

import org.apache.struts2.dispatcher.SessionMap;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class UserWijzigen extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String adres;
	private String postcode;
	private String plaats;
	private String email;
	private String telefoonnummer;
	private int rekeningnummer;
	private int klantnummer;
	private Gebruiker gebruiker;

	SessionMap<String, String> sessionmap;

	public String execute() {
		int intTelefoonnummer = Integer.parseInt(telefoonnummer);
		System.out.println("Klantnr: " + klantnummer);
		if (VeilingService.updateGebruiker(voornaam, tussenvoegsel, achternaam,
				adres, postcode, plaats, email, intTelefoonnummer, rekeningnummer, klantnummer)) {
			addActionMessage("De wijzigingen zijn opgeslagen");
			gebruiker = VeilingService.retrieveUser(klantnummer);
			return SUCCESS;
		} else
			return INPUT;
	}

	public void validate() {
		gebruiker = VeilingService.retrieveUser(klantnummer);
		String stringRekeningnummer = Integer.toString(rekeningnummer);
		if (voornaam.equals(""))
			addFieldError("voornaam", "Geef je voornaam op");
		if (achternaam.equals(""))
			addFieldError("achtenraam", "Geef je achternaam op");
		if (adres.equals(""))
			addFieldError("voornaam", "Geef je adres op");
		if (!postcode.matches("^[1-9]{1}[0-9]{3} ?[A-Z]{2}$"))
			addFieldError("postcode", "Geef een geldige postcode op");
		if (plaats.equals(""))
			addFieldError("plaats", "Geef je plaats op");
		if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
			addFieldError("email", "Geef een geldig e-mailadres op");
		if (!telefoonnummer.matches("[0-9]{10}"))
			addFieldError("telefoonnummerForm", "Geef een geldig telefoonnummer op");
		if (stringRekeningnummer.equals(""))
			addFieldError("rekeningnummer", "Geef je rekeningnummer op");
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
	public void setRekeningnummer(int rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}
	
	public void setTelefoonnummerForm(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public int getKlantnummer() {
		return klantnummer;
	}

	public void setKlantnummer(int klantnummer) {
		this.klantnummer = klantnummer;
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

	public String getAdres() {
		return adres;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getPlaats() {
		return plaats;
	}

	public String getEmail() {
		return email;
	}

	public int getRekeningnummer() {
		return rekeningnummer;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	
}
