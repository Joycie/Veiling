package veilingActions.member;

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
	SessionMap<String, String> sessionmap;

	public String execute() {
		Gebruiker gebruiker = (Gebruiker) session.get("gebruiker");
		if (gebruiker.getRol() == 1) {
			Aanbieding aanbieding = new Aanbieding(id, 0, null, 0, null, 0,
					null);
			VeilingService.deleteAanbieding(aanbieding);
		} else {
			Aanbieding aanbieding = new Aanbieding(id, 0, null,
					gebruiker.getKlantnummer(), null, 0, null);
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

}
