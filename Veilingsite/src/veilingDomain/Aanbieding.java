package veilingDomain;

import java.io.File;
import java.sql.Timestamp;

public class Aanbieding {

	private int id;
	private double startprijs;
	private Timestamp eindtijd, insert_date;
	private int gebruikers_klantnr, drukken_nummer;
	private String drukken_isbn;
	private Boek boek;
	private Bod bod;
	private byte[] img;

	public Aanbieding(int boekid, double start, Timestamp eind, int geb_klant, String druk_isbn, int druk_nr, Boek boek) 
	{
		id = boekid;
		startprijs = start;
		eindtijd = eind;
		gebruikers_klantnr = geb_klant;
		drukken_isbn = druk_isbn;
		drukken_nummer = druk_nr;
		this.boek = boek;
	}
	
	public Aanbieding(int boekid, double start, Timestamp eind, Timestamp i_date, int geb_klant, String druk_isbn, int druk_nr, Boek boek, Bod bod, byte[] i) 
	{
		id = boekid;
		startprijs = start;
		eindtijd = eind;
		insert_date = i_date;
		gebruikers_klantnr = geb_klant;
		drukken_isbn = druk_isbn;
		drukken_nummer = druk_nr;
		this.boek = boek;
		this.bod = bod;
		img = i;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getStartprijs() {
		return startprijs;
	}

	public void setStartprijs(double startprijs) {
		this.startprijs = startprijs;
	}
	
	public Timestamp getEindtijd() {
		return eindtijd;
	}

	public void setEindtijd(Timestamp eindtijd) {
		this.eindtijd = eindtijd;
	}

	public int getGebruikers_klantnr() {
		return gebruikers_klantnr;
	}

	public void setGebruikers_klantnr(int gebruikers_klantnr) {
		this.gebruikers_klantnr = gebruikers_klantnr;
	}

	public String getDrukken_isbn() {
		return drukken_isbn;
	}

	public void setDrukken_isbn(String drukken_isbn) {
		this.drukken_isbn = drukken_isbn;
	}

	public int getDrukken_nummer() {
		return drukken_nummer;
	}

	public void setDrukken_nummer(int drukken_nummer) {
		this.drukken_nummer = drukken_nummer;
	}
	public Boek getBoek() {
		return boek;
	}

	public void setBoek(Boek boek) {
		this.boek = boek;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Timestamp getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}

	public Bod getBod() {
		return bod;
	}

	public void setBod(Bod bod) {
		this.bod = bod;
	}
	
	
}
