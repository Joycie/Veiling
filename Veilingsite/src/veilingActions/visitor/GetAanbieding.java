package veilingActions.visitor;
import veilingDomain.Aanbieding;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;
import com.opensymphony.xwork2.ActionSupport;

public class GetAanbieding extends ActionSupport {
	private int id;
	private Aanbieding aanbieding;
	private Gebruiker gebruiker;
	
	public String execute() {
		aanbieding = VeilingService.getAanbieding(id);
		gebruiker = VeilingService.getGebruiker(aanbieding.getGebruikers_klantnr());
		return SUCCESS;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aanbieding getAanbieding() {
		return aanbieding;
	}

	public void setAanbieding(Aanbieding aanbieding) {
		this.aanbieding = aanbieding;
	}

	public int getId() {
		return id;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}
}
