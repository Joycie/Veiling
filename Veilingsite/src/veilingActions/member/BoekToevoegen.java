package veilingActions.member;

import java.util.Date;

import veilingDomain.Boek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class BoekToevoegen extends ActionSupport {
	private String isbn;
	private String titel;
	private String beschrijving;
	private String uitgeverij;
	private Date datum;
	private String druk;
	private String taal;
	private int aantalbladzijde;
	private String auteur;

	public String execute() {
		Boek boek = new Boek(isbn, aantalbladzijde, titel, druk, beschrijving,
				uitgeverij, taal, auteur, datum);
		if (VeilingService.voegBoekToe(boek) == true) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public void setUitgeverij(String uitgeverij) {
		this.uitgeverij = uitgeverij;
	}

	public void setDatum(String jaar, String maand, String dag) {

	}

	public void setDruk(String druk) {
		this.druk = druk;
	}

	public void setTaal(String taal) {
		this.taal = taal;
	}

	public void setAantalbladzijde(String aantalbladzijde) {
		this.aantalbladzijde = Integer.parseInt(aantalbladzijde);
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
}
