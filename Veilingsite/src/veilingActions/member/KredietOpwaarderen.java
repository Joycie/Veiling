package veilingActions.member;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import veilingActions.DAO.GebruikerDAO;
import veilingDomain.Gebruiker;

public class KredietOpwaarderen extends ActionSupport implements SessionAware {

	private Gebruiker gebruiker;
	private double nieuw, oud;
	private GebruikerDAO gebruikerDAO = new GebruikerDAO();

	
	

	@Override
	public void setSession(Map<String, Object> session) {
		gebruiker = (Gebruiker)session.get("gebruiker");
	}


	public String execute(){
		gebruiker.setKrediet(nieuw + oud);
		System.out.println(nieuw + " " + oud );
		System.out.println(gebruiker.getVoornaam());
		return SUCCESS;
	}

	
	//getters en setters
	
	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public double getNieuw() {
		return nieuw;
	}

	public void setNieuw(double nieuw) {
		this.nieuw = nieuw;
	}

	public double getOud() {
		return oud;
	}

	public void setOud(double oud) {
		this.oud = oud;
	}
	
}
