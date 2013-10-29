package veilingActions.member;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import veilingActions.DAO.GebruikerDAO;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

public class KredietOpwaarderen extends ActionSupport implements SessionAware {
	private SessionMap session;
	private Gebruiker gebruiker;
	private double saldo;
	SessionMap<String, String> sessionmap;
	public String execute(){
		gebruiker = (Gebruiker) session.get("gebruiker");
		System.out.println("Klantnr: " + gebruiker.getKlantnummer());
		if (VeilingService.updateKrediet(gebruiker.getKlantnummer(), saldo)) {
			gebruiker = new Gebruiker(gebruiker.getKlantnummer(), gebruiker.getVoornaam(), gebruiker.getTussenvoegsel(), gebruiker.getAchternaam(), gebruiker.getAdres(), gebruiker.getPostcode(), gebruiker.getPlaats(), gebruiker.getEmail(), gebruiker.getTelefoonnummer(), gebruiker.getRekeningnummer(), saldo);
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put("gebruiker", gebruiker);
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) session;
	}
	//getters en setters
	
	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public SessionMap getSession() {
		return session;
	}

	public void setSession(SessionMap session) {
		this.session = session;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public SessionMap<String, String> getSessionmap() {
		return sessionmap;
	}

	public void setSessionmap(SessionMap<String, String> sessionmap) {
		this.sessionmap = sessionmap;
	}
	
}
