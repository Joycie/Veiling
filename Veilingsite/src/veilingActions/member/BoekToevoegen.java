package veilingActions.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import veilingDomain.Boek;
import veilingDomain.Veiling;
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
	private String categorielijst;
	private int categorie;
	private File img;


	public String execute() {
		categorie = Integer.parseInt(categorielijst);
		Boek boek = new Boek(isbn, aantalbladzijde, titel, druk, beschrijving,
				uitgeverij, taal, auteur, datum, categorie);
		if (VeilingService.voegBoekToe(boek) == true) {
			addActionMessage("Boek : " + titel + " is toegevoegd.");
			if(img != null){
				byte[] blob = new byte[(int) img.length()];
				try {
					FileInputStream fileInputStream = new FileInputStream(img);
				     //convert file into array of bytes
				     fileInputStream.read(blob);
				     fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				veiling.setImage(blob);
			}	
			return SUCCESS;
		} else {
			addActionError("Toevoegen niet gelukt");
			return INPUT;
		}
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
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
	
}
	
