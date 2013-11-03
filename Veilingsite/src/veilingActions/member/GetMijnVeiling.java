package veilingActions.member;

import java.sql.Timestamp;
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
	private Timestamp sysdate;
	
	public String execute(){
		java.util.Date date = new java.util.Date();
		sysdate = new Timestamp(date.getTime());
		sysdate.setDate(sysdate.getDate() - 1);
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
	public Timestamp getSysdate() {
		return sysdate;
	}

	public void setSysdate(Timestamp sysdate) {
		this.sysdate = sysdate;
	}
}
