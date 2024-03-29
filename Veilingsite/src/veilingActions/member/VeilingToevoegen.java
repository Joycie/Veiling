package veilingActions.member;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingDomain.Categorie;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class VeilingToevoegen extends ActionSupport implements SessionAware {
	private int id = 0;
	private double startprijs;
	private Timestamp eindtijd;
	private int gebruikers_klantnr, druk, dagen;
	private String isbn;
	private Aanbieding aanbieding;
	private SessionMap session;
	private File img;
	private byte[] blob;
	SessionMap<String, String> sessionmap;
	private ArrayList<Categorie> categorielijst = new ArrayList<Categorie>(VeilingService.getCategorielijst());
	private List<Categorie> categories = new ArrayList<Categorie>();

	public VeilingToevoegen() {

	}

	public String execute() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		eindtijd = new Timestamp(date.getTime());
		System.out.println("Dagen: " + dagen);
		eindtijd.setDate(eindtijd.getDate() + dagen);
		System.out.println(eindtijd);
		Gebruiker geb = (Gebruiker) session.get("gebruiker");
		gebruikers_klantnr = geb.getKlantnummer();
		
		if (!VeilingService.checkBoek(isbn)) {
			addActionError("Boek bestaat niet");
			VeilingService.retrieveCategories();
			categorielijst = new ArrayList<Categorie>(VeilingService.getCategorielijst());
			categories = categorielijst;	
			System.out.println(categories);
			return ERROR;

		}
		if (VeilingService.getBoek(isbn) == null) {
			addActionError("Boek bestaat niet");
			VeilingService.retrieveCategories();
			categorielijst = new ArrayList<Categorie>(VeilingService.getCategorielijst());
			categories = categorielijst;
			System.out.println(categories);
			return ERROR;
		}
		Boek boek = VeilingService.getBoek(isbn);
		aanbieding = new Aanbieding(id, startprijs, eindtijd,
				gebruikers_klantnr, isbn, druk, boek);
		
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
			aanbieding.setImg(blob);

		}

		if (!VeilingService.voegVeilingToe(aanbieding)) {
			addActionError("Toevoegen niet gelukt");
			return INPUT;
		}
		addActionMessage("Veiling toegevoegd");

		return SUCCESS;

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

	public int getDruk() {
		return druk;
	}

	public void setDruk(int druk) {
		this.druk = druk;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getDagen() {
		return dagen;
	}

	public void setDagen(int dagen) {
		this.dagen = dagen;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap) session;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public ArrayList<Categorie> getCategorielijst() {
		return categorielijst;
	}

	public void setCategorielijst(ArrayList<Categorie> categorielijst) {
		this.categorielijst = categorielijst;
	}
	
}
