package veilingActions.admin;

import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserZoeken extends ActionSupport {
	private Gebruiker gebruiker;
	private int klantnummer;
	
	public String execute() {
		System.out.println("Klantnummer: " + klantnummer);
		gebruiker = VeilingService.retrieveUser(klantnummer);
		System.out.println(gebruiker.getVoornaam());
		return SUCCESS;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public int getKlantnummer() {
		return klantnummer;
	}

	public void setKlantnummer(int klantnummer) {
		this.klantnummer = klantnummer;
	}

	
}