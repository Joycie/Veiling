package veilingActions.member;

import java.sql.Date;

import veilingDomain.Boek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class BoekToevoegen extends ActionSupport {
	private String isbn;
	private String titel;
	private String beschrijving;
	private String uitgeverij;
	private Date datum;
	private int druk;
	private String taal;
	private int aantalbladzijde;
	private String auteur;

	public String execute() {
		Boek boek = new Boek(isbn, aantalbladzijde, titel, druk, beschrijving,
				uitgeverij, taal, auteur, datum);
		if (VeilingService.voegBoekToe(boek) == true) {
			addActionMessage("Boek : " + titel + " is toegevoegd.");
			return SUCCESS;
		} else {
			addActionError("Toevoegen niet gelukt");
			return INPUT;
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		System.out.println("Datum: " + datum);
		this.datum = datum;
	}
	
	public int getDruk() {
		return druk;
	}

	public void setDruk(int druk) {
		this.druk = druk;
	}

	public String getTaal() {
		return taal;
	}

	public void setTaal(String taal) {
		this.taal = taal;
	}

	public int getAantalbladzijde() {
		return aantalbladzijde;
	}

	public void setAantalbladzijde(int aantalbladzijde) {
		this.aantalbladzijde = aantalbladzijde;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
}
