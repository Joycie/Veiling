package veilingActions.member;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import veilingDomain.Boek;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WachtwoordWijzigen extends ActionSupport implements SessionAware {
	private SessionMap session;
	private String oudwachtwoord, nieuwwachtwoord, checknieuwwachtwoord;
	private Gebruiker geb, gebruiker;
	SessionMap<String, String> sessionmap;
	

	public String execute() {
		geb = (Gebruiker) session.get("gebruiker");
		VeilingService.setWachtwoord(geb.getKlantnummer(), nieuwwachtwoord);
		gebruiker = VeilingService.getGebruiker(geb.getKlantnummer());
		session.put("gebruiker", gebruiker);
		addActionMessage("Wachtwoord aangepast.");
		return SUCCESS;
		
	}

	public void validate() {
		geb = (Gebruiker) session.get("gebruiker");
		if (!oudwachtwoord.equals(geb.getWachtwoord())) {
			addFieldError("oudwachtwoord",
					"Je huidige wachtwoord komt niet overeen met je invoer");
		}
		if (!nieuwwachtwoord.matches("^(?=.*[0-9]).{6,}$")) {
			addFieldError("nieuwwachtwoord",
					"Geef een wachtwoord op met minimaal 6 tekens, 1 cijfer");
		}
		if (nieuwwachtwoord.equals(oudwachtwoord)) {
			addFieldError("nieuwwachtwoord",
					"Dit is al je huidige wachtwoord");
		}
		if (!nieuwwachtwoord.equals(checknieuwwachtwoord)) {
			addFieldError("checknieuwwachtwoord",
					"De wachtwoorden komen niet overeen");
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) session;
	}

	public String getOudwachtwoord() {
		return oudwachtwoord;
	}

	public void setOudwachtwoord(String oudwachtwoord) {
		this.oudwachtwoord = oudwachtwoord;
	}

	public String getNieuwwachtwoord() {
		return nieuwwachtwoord;
	}

	public void setNieuwwachtwoord(String nieuwwachtwoord) {
		this.nieuwwachtwoord = nieuwwachtwoord;
	}

	public String getChecknieuwwachtwoord() {
		return checknieuwwachtwoord;
	}

	public void setChecknieuwwachtwoord(String checknieuwwachtwoord) {
		this.checknieuwwachtwoord = checknieuwwachtwoord;
	}

}
