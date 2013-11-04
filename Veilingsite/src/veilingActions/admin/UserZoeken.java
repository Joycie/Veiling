package veilingActions.admin;

import java.sql.Timestamp;
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
	private Timestamp sysdate;
	
	public String execute() {
		java.util.Date date = new java.util.Date();
		sysdate = new Timestamp(date.getTime());
		sysdate.setDate(sysdate.getDate() - 1);
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

	public Timestamp getSysdate() {
		return sysdate;
	}

	public void setSysdate(Timestamp sysdate) {
		this.sysdate = sysdate;
	}	
}