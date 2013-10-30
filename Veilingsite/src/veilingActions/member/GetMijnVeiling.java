package veilingActions.member;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import veilingDomain.Aanbieding;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class GetMijnVeiling extends ActionSupport implements SessionAware {
	private SessionMap session;
	private ArrayList<Aanbieding> mijnveilingen = new ArrayList<Aanbieding>();
	SessionMap<String, String> sessionmap;
	
	public String execute(){
		Gebruiker geb = (Gebruiker) session.get("gebruiker");
		int klantnr = geb.getKlantnummer();
		mijnveilingen = VeilingService.getMijnveilingen(klantnr);
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap) session;
	}

	public ArrayList<Aanbieding> getMijnveilingen() {
		return mijnveilingen;
	}

	public void setMijnveilingen(ArrayList<Aanbieding> mijnveilingen) {
		this.mijnveilingen = mijnveilingen;
	}
	
}
