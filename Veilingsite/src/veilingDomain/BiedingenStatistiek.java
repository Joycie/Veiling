package veilingDomain;

public class BiedingenStatistiek {
	private int id;
	private String voornaam;
	private String tussenvoegsel;
	private String achternam;
	private String titel;
	private int biedingen;
	
	public BiedingenStatistiek(int id, String voornaam, String tussenvoegsel,
			String achternam, String titel, int biedingen) {
		super();
		this.id = id;
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternam = achternam;
		this.titel = titel;
		this.biedingen = biedingen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAchternam() {
		return achternam;
	}
	public void setAchternam(String achternam) {
		this.achternam = achternam;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getBiedingen() {
		return biedingen;
	}
	public void setBiedingen(int biedingen) {
		this.biedingen = biedingen;
	}
	
	
}
