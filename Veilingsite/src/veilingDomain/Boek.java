package veilingDomain;

import java.sql.Date;

public class Boek {

	private int druk, aantalpagina, categorie;
	private String titel, beschrijving, uitgeverij, taal, auteur, isbn;
	private Date datum;

	public Boek(String is, int ap, String ttl, int drk, String besch, String uit, String tl, String aut, Date dat, int cat) 
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
		categorie = cat;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
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
	

	public int getDruk() {
		return druk;
	}

	public void setDruk(int druk) {
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

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
}
