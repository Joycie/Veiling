package veilingDomain;

public class Gebruiker {

	private int klantnummer, telefoonnummer, rekeningnummer, rol;
	private String voornaam, tussenvoegsel, achternaam, adres, postcode,
			plaats, email, wachtwoord;
	private double krediet;
	
	public Gebruiker(String vrn, String tv, String an, String adr,
			String post, String plts, String em, String ww, int telnr,
			int reknr) 
	{
		voornaam = vrn;
		tussenvoegsel = tv;
		achternaam = an;
		adres = adr;
		postcode = post;
		plaats = plts;
		email = em;
		wachtwoord = ww;
		telefoonnummer = telnr;
		rekeningnummer = reknr;	
	}
	
	public Gebruiker(int klntnr, String vrn, String tv, String an, String adr,
			String post, String plts, String em, int telnr,
			int reknr) 
	{
		klantnummer = klntnr;
		voornaam = vrn;
		tussenvoegsel = tv;
		achternaam = an;
		adres = adr;
		postcode = post;
		plaats = plts;
		email = em;
		telefoonnummer = telnr;
		rekeningnummer = reknr;	
	}


	public Gebruiker(int klnr, String vrn, String tv, String an, String adr,
			String post, String plts, String em, String ww, int telnr,
			int reknr, double kred, int rl) 
	{
		klantnummer = klnr;
		voornaam = vrn;
		tussenvoegsel = tv;
		achternaam = an;
		adres = adr;
		postcode = post;
		plaats = plts;
		email = em;
		wachtwoord = ww;
		telefoonnummer = telnr;
		rekeningnummer = reknr;
		krediet = kred;	
		rol = rl;
	}
	
	public Gebruiker(int klnr, String vrn, String tv, String an, String adr,
			String post, String plts, String em, int telnr,
			int reknr, double kred) 
	{
		klantnummer = klnr;
		voornaam = vrn;
		tussenvoegsel = tv;
		achternaam = an;
		adres = adr;
		postcode = post;
		plaats = plts;
		email = em;
		telefoonnummer = telnr;
		rekeningnummer = reknr;
		krediet = kred;	
	}


	public int getKlantnummer() {
		return klantnummer;
	}

	public void setKlantnummer(int klantnummer) {
		this.klantnummer = klantnummer;
	}

	public int getTelefoonnummer() {
		return telefoonnummer;
	}
	
	public String getTelefoonnummerForm() {
		return String.format("%4d", telefoonnummer);
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

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	public double getKrediet() {
		return krediet;
	}
	public void setKrediet(double krediet) {
		this.krediet = krediet;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
}
