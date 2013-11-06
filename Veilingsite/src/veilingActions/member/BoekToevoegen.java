package veilingActions.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import veilingDomain.Boek;
import veilingDomain.Categorie;
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
	private int aantalpagina;
	private String auteur;
	private String categorielijst;
	private int categorie;
	private ArrayList<Categorie> categorielijstdb = new ArrayList<Categorie>(VeilingService.getCategorielijst());
	private List<Categorie> categories = new ArrayList<Categorie>();

	public String execute() {
		categorie = Integer.parseInt(categorielijst);
		Boek boek = new Boek(isbn, aantalpagina, titel, druk, beschrijving,
				uitgeverij, taal, auteur, datum, categorie);
		if (VeilingService.voegBoekToe(boek) == true) {
			addActionMessage("Boek : " + titel + " is toegevoegd.");

			return SUCCESS;
		} else {
			addActionError("Toevoegen niet gelukt");
			VeilingService.retrieveCategories();
			categorielijstdb = new ArrayList<Categorie>(VeilingService.getCategorielijst());
			categories = categorielijstdb;
			return INPUT;
		}
	}
	public void validate() {
		VeilingService.retrieveCategories();
		categorielijstdb = new ArrayList<Categorie>(VeilingService.getCategorielijst());
		categories = categorielijstdb;
		if(isbn.equals(""))
		{
			addFieldError("isbn", "ISBN mag niet leeg zijn");
		}
		if(titel.equals(""))
		{
			addFieldError("titel", "Titel mag niet leeg zijn");
		}
		if(beschrijving.equals(""))
		{
			addFieldError("beschrijving", "Beschrijving mag niet leeg zijn");
		}
		if(uitgeverij.equals(""))
		{
			addFieldError("uitgeverij", "Uitgeverij mag niet leeg zijn");
		}
		if(taal.equals(""))
		{
			addFieldError("taal", "Taal mag niet leeg zijn");
		}
		if(auteur.equals(""))
		{
			addFieldError("auteur", "Auteur mag niet leeg zijn");
		}
		if(categorielijst.equals(""))
		{
			addFieldError("categorielijst", "Categorie mag niet leeg zijn");
		}
		String stringDruk = Integer.toString(druk);
		if(stringDruk.equals(""))
		{
			addFieldError("druk", "Druk mag niet leeg zijn");
		}
		String stringAantalpagina = Integer.toString(aantalpagina);
		if(stringAantalpagina.equals(""))
		{
			addFieldError("aantalbladzijde", "Aantal pagina's mag niet leeg zijn");
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
	
	public int getAantalpagina() {
		return aantalpagina;
	}
	public void setAantalpagina(int aantalpagina) {
		this.aantalpagina = aantalpagina;
	}
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getCategorielijst() {
		return categorielijst;
	}

	public void setCategorielijst(String categorielijst) {
		this.categorielijst = categorielijst;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
}
	
