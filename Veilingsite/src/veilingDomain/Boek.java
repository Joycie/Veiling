package veilingDomain;

import java.util.Date;

public class Boek {

	private int isbn, aantalpagina;
	private String titel, druk, beschrijving, uitgeverij, taal, auteur;
	private Date datum;

	public Boek(int is, int ap, String ttl, String drk, String besch, String uit, String tl, String aut, Date dat) 
	{
		isbn = is;
		aantalpagina = ap;
		titel = ttl;
		druk = drk;
		beschrijving = besch;
		uitgeverij = uit;
		taal = tl;
		auteur = aut;
		datum = dat;

	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getAantalpagina() {
		return aantalpagina;
	}

	public void setAantalpagina(int aantalpagina) {
		this.aantalpagina = aantalpagina;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getDruk() {
		return druk;
	}

	public void setDruk(String druk) {
		this.druk = druk;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public String getUitgeverij() {
		return uitgeverij;
	}

	public void setUitgeverij(String uitgeverij) {
		this.uitgeverij = uitgeverij;
	}

	public String getTaal() {
		return taal;
	}

	public void setTaal(String taal) {
		this.taal = taal;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
}
