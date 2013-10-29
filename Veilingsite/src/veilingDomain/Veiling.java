package veilingDomain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Veiling {

	private int id;
	private String titel;
	private String omschrijving;
	private Categorie categorie;
	private String status;
	private int minimumBod;
	private Gebruiker gebruiker;
	private Date eindDatum;
	private byte[] image;
	private Set<Bod> biedingen = new HashSet<Bod>();
	
	//getters en setters
	
	public int getId() {
		return id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMinimumBod() {
		return minimumBod;
	}
	public void setMinimumBod(int minimumBod) {
		this.minimumBod = minimumBod;
	}
	public Gebruiker getGebruiker() {
		return gebruiker;
	}
	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
	public Date getEindDatum() {
		return eindDatum;
	}
	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}
	public Set<Bod> getBiedingen() {
		return biedingen;
	}
	public void setBiedingen(Set<Bod> biedingen) {
		this.biedingen = biedingen;
	}
	
}
