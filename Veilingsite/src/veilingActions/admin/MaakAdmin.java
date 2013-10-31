package veilingActions.admin;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Aanbieding;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MaakAdmin extends ActionSupport implements SessionAware {
	private SessionMap session;
	private int klantnummer;
	private Gebruiker gebruiker, sessionGebruiker;
	private ArrayList<Aanbieding> aanbiedingen = new ArrayList<Aanbieding>();

	public String execute() {
		VeilingService.giveAdmin(klantnummer);
		gebruiker = VeilingService.retrieveUser(klantnummer);
		return SUCCESS;
	}

	public void validate() {
		SessionMap<String, String> sessionmap;
		sessionGebruiker = (Gebruiker) session.get("gebruiker");
		
		gebruiker = VeilingService.retrieveUser(klantnummer);
		aanbiedingen = VeilingService.getMijnveilingen(klantnummer);
		
		if (gebruiker.getRol() == 2) {
			addActionError("De gebruiker is geblokkeerd.");
		}
		if (gebruiker.getRol() == 1) {
			addActionError("De gebruiker is al een admin.");
		}
		if (sessionGebruiker.getKlantnummer() == gebruiker.getKlantnummer()) {
			addActionError("Je kan je eigen adminrechten niet innemen.");
		}
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

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) session;
	}

	public Gebruiker getSessionGebruiker() {
		return sessionGebruiker;
	}

	public void setSessionGebruiker(Gebruiker sessionGebruiker) {
		this.sessionGebruiker = sessionGebruiker;
	}

	public ArrayList<Aanbieding> getAanbiedingen() {
		return aanbiedingen;
	}

	public void setAanbiedingen(ArrayList<Aanbieding> aanbiedingen) {
		this.aanbiedingen = aanbiedingen;
	}
	
}