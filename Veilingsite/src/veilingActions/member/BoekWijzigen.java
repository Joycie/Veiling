package veilingActions.member;

import java.sql.Date;

import veilingDomain.Boek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class BoekWijzigen extends ActionSupport {
	private int druk, aantalpagina, categorie;
	private String titel, beschrijving, uitgeverij, taal, auteur, isbn;
	private Date datum;
	
	public String execute(){
		System.out.println(isbn);
		Boek boek = new Boek(isbn, aantalpagina, titel, druk, beschrijving, uitgeverij, taal, auteur, datum, categorie);
		if (VeilingService.BoekWijzigen(boek)){
			addActionMessage("Boek : " + titel + " is gewijzigd.");
			return SUCCESS;
		}
		addActionError("Wijzigen niet gelukt");
		return INPUT;
	}

	public int getDruk() {
		return druk;
	}

	public void setDruk(int druk) {
		this.druk = druk;
	}

	public int getAantalpagina() {
		return aantalpagina;
	}

	public void setAantalpagina(int aantalpagina) {
		this.aantalpagina = aantalpagina;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
