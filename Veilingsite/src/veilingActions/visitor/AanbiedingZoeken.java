package veilingActions.visitor;

import java.sql.Timestamp;
import java.util.ArrayList;

import veilingDomain.Aanbieding;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class AanbiedingZoeken extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ArrayList<Aanbieding> gezochteveilingen = new ArrayList<Aanbieding>();
	private String invoer;
	private Timestamp sysdate;
	public String execute() {
		java.util.Date date = new java.util.Date();
		sysdate = new Timestamp(date.getTime());
		sysdate.setDate(sysdate.getDate() - 1);
		gezochteveilingen = VeilingService.getGezochteVeilingen(invoer);
		System.out.println(gezochteveilingen);
		return SUCCESS;
	}
	public void validate()
	{
		invoer.trim();
	}

	public ArrayList<Aanbieding> getGezochteveilingen() {
		return gezochteveilingen;
	}

	public void setGezochteveilingen(ArrayList<Aanbieding> gezochteveilingen) {
		this.gezochteveilingen = gezochteveilingen;
	}

	public String getInvoer() {
		return invoer;
	}

	public void setInvoer(String invoer) {
		this.invoer = invoer;
	}

	public Timestamp getSysdate() {
		return sysdate;
	}

	public void setSysdate(Timestamp sysdate) {
		this.sysdate = sysdate;
	}
	
}
