package veilingActions.member;

import java.sql.Timestamp;
import java.util.Map;

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
	private Timestamp eindtijd;
	private int gebruikers_klantnr, drukken_nummer;
	private String drukken_isbn;
	private Boek boek;
	private byte[] img;
	private SessionMap session;
	SessionMap<String, String> sessionmap;
	
	public String execute(){
		Gebruiker geb = (Gebruiker) session.get("gebruiker");
		gebruikers_klantnr = geb.getKlantnummer();
		System.out.println("ID: " + id);
		System.out.println("Eindtijd: " + eindtijd);
		eindtijd.setDate(eindtijd.getDate() + dagen);
		System.out.println("Eindtijd na toevoegen: " + eindtijd);
		Aanbieding aanbieding = new Aanbieding(id, startprijs, eindtijd, gebruikers_klantnr, drukken_isbn, drukken_nummer, boek);
		if (VeilingService.aanbiedingWijzigen(aanbieding)){
			addActionMessage("Veiling is gewijzigd.");
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
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
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
	
	
}
