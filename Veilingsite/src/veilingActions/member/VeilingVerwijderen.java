package veilingActions.member;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Aanbieding;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class VeilingVerwijderen extends ActionSupport implements SessionAware {
	private int id;
	private SessionMap session;
	private ArrayList<Aanbieding> mijnveilingen = new ArrayList<Aanbieding>();
	SessionMap<String, String> sessionmap;

	public String execute() {
		Gebruiker gebruiker = (Gebruiker) session.get("gebruiker");
		if (gebruiker.getRol() == 1) {
			Aanbieding aanbieding = VeilingService.getAanbieding(id);
			aanbieding.setGebruikers_klantnr(0);
			System.out.println("Bieder klantnr: " + aanbieding.getBod().getKlantnr() + " bedrag: " + aanbieding.getBod().getBedrag() );
			VeilingService.updateKrediet(aanbieding.getBod().getKlantnr(), aanbieding.getBod().getBedrag());
			VeilingService.deleteAanbieding(aanbieding);
		} else {
			Aanbieding aanbieding = VeilingService.getAanbieding(id);
			System.out.println("Bedrag: " + aanbieding.getBod().getBedrag() + " startprijs: " + aanbieding.getStartprijs());
			if(aanbieding.getBod().getBedrag() > aanbieding.getStartprijs())
			{
				mijnveilingen = VeilingService.getMijnveilingen(gebruiker.getKlantnummer());
				addActionError("Je mag een veiling niet verwijderen als er op geboden is.");
				return INPUT;
			}
			System.out.println("Bieder klantnr: " + aanbieding.getBod().getKlantnr() + " bedrag: " + aanbieding.getBod().getBedrag() );
			VeilingService.updateKrediet(aanbieding.getBod().getKlantnr(), aanbieding.getBod().getBedrag());
			VeilingService.deleteAanbieding(aanbieding);
			
		}
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap) session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Aanbieding> getMijnveilingen() {
		return mijnveilingen;
	}
	public void setMijnveilingen(ArrayList<Aanbieding> mijnveilingen) {
		this.mijnveilingen = mijnveilingen;
	}
	
}
