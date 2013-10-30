package veilingActions.admin;

import java.util.ArrayList;

import veilingDomain.Aanbieding;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserZoeken extends ActionSupport {
	private Gebruiker gebruiker;
	private ArrayList<Aanbieding> aanbiedingen = new ArrayList<Aanbieding>();
	private int klantnummer;
	
	public String execute() {
		System.out.println("Klantnummer: " + klantnummer);
		gebruiker = VeilingService.retrieveUser(klantnummer);
		aanbiedingen = VeilingService.getMijnveilingen(klantnummer);
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

	public ArrayList<Aanbieding> getAanbiedingen() {
		return aanbiedingen;
	}

	public void setAanbieding(ArrayList<Aanbieding> aanbiedingen) {
		this.aanbiedingen = aanbiedingen;
	}
	
	
}