package veilingActions.admin;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

public class VeilingWijzigen extends ActionSupport implements SessionAware {
	private int id, dagen;
	private double startprijs;
	private Timestamp eindtijd, insert_date;
	private int gebruikers_klantnr, drukken_nummer;
	private String drukken_isbn;
	private Boek boek;
	private File img;
	private byte[] blob;
	private SessionMap session;
	SessionMap<String, String> sessionmap;
	
	public String execute(){
		Gebruiker geb = (Gebruiker) session.get("gebruiker");
		gebruikers_klantnr = geb.getKlantnummer();
		System.out.println("ID: " + id);
		System.out.println("Eindtijd: " + eindtijd);
		eindtijd.setDate(eindtijd.getDate() + dagen);
		System.out.println("Eindtijd na toevoegen: " + eindtijd);
		
		if (img != null) {
			try {
				Image image = ImageIO.read(img);
				if (image == null) {
					addActionError("File is geen image");
					System.out.println("File is geen image.");
					return INPUT;

				}
			} catch (IOException ex) {
				System.out.println("Kan bestand niet openen");
			}

			blob = new byte[(int) img.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(img);
				// convert file into array of bytes
				fileInputStream.read(blob);
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		Aanbieding aanbieding = new Aanbieding(id, startprijs, eindtijd, insert_date, gebruikers_klantnr, drukken_isbn, drukken_nummer, boek, null, blob);
		if (VeilingService.aanbiedingWijzigen(aanbieding)){
			addActionMessage("Veiling is gewijzigd.");
			aanbieding = VeilingService.getAanbieding(id);
			return SUCCESS;
		}
		addActionError("Wijzigen niet gelukt");
		return INPUT;
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
	public int getDrukken_nummer() {
		return drukken_nummer;
	}
	public void setDrukken_nummer(int drukken_nummer) {
		this.drukken_nummer = drukken_nummer;
	}
	public String getDrukken_isbn() {
		return drukken_isbn;
	}
	public void setDrukken_isbn(String drukken_isbn) {
		this.drukken_isbn = drukken_isbn;
	}
	public Boek getBoek() {
		return boek;
	}
	public void setBoek(Boek boek) {
		this.boek = boek;
	}
	
	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public byte[] getBlob() {
		return blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap) session;
	}

	public int getDagen() {
		return dagen;
	}

	public void setDagen(int dagen) {
		this.dagen = dagen;
	}

	public Timestamp getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}

	public int getGebruikers_klantnr() {
		return gebruikers_klantnr;
	}

	public void setGebruikers_klantnr(int gebruikers_klantnr) {
		this.gebruikers_klantnr = gebruikers_klantnr;
	}
	
	
}
