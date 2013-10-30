package veilingDomain;

import java.io.File;
import java.sql.Timestamp;

public class Aanbieding {

	private int id;
	private double startprijs;
	private Timestamp eindtijd;
	private int gebruikers_klantnr, drukken_nummer;
	private String drukken_isbn;
	private Boek boek;
	private byte[] img;

	public Aanbieding(int boekid, double start, Timestamp eind, int geb_klant, String druk_isbn, int druk_nr, Boek b) 
	{
		id = boekid;
		startprijs = start;
		eindtijd = eind;
		gebruikers_klantnr = geb_klant;
		drukken_isbn = druk_isbn;
		drukken_nummer = druk_nr;
		boek = b;
	}
	
	public Aanbieding(int boekid, double start, Timestamp eind, int geb_klant, String druk_isbn, int druk_nr, Boek b, byte[] i) 
	{
		id = boekid;
		startprijs = start;
		eindtijd = eind;
		gebruikers_klantnr = geb_klant;
		drukken_isbn = druk_isbn;
		drukken_nummer = druk_nr;
		boek = b;
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
	
	
}
