package veilingActions.admin;

import java.util.ArrayList;

import veilingDomain.Aanbieding;
import veilingDomain.BiedingenStatistiek;
import veilingDomain.Statistiek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class GetStatistieken extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Statistiek statistiek;
	private Aanbieding aanbieding;
	private ArrayList<BiedingenStatistiek> biedingenStatistieken = new ArrayList<BiedingenStatistiek>();
	private String van = "01/01/2013";
	private String tot = "01/01/2013";
	private int opbrengst = 0;

	public String execute() {
		opbrengst = VeilingService.getOpbrengst(van, tot);
		statistiek = VeilingService.retrieveStatistieken();	
		biedingenStatistieken = VeilingService.getBiedingenStatistieken();
		return SUCCESS;
	}
	
	public int getOpbrengst() {
		return opbrengst;
	}

	public void setOpbrengst(int opbrengst) {
		this.opbrengst = opbrengst;
	}

	public void validate() {
		/*if(!van.matches("^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$")) {
			addFieldError("van","Geef een geldige van-datum (DD/MM/YYYY) op.");
		} 
		
		if(!tot.matches("^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$")) {
			addFieldError("tot","Geef een geldige tot-datum (DD/MM/YYYY) op.");
		}*/
	}

	public ArrayList<BiedingenStatistiek> getBiedingenStatistieken() {
		return biedingenStatistieken;
	}

	public void setBiedingenStatistieken(
			ArrayList<BiedingenStatistiek> biedingenStatistieken) {
		this.biedingenStatistieken = biedingenStatistieken;
	}

	public Statistiek getStatistiek() {
		return statistiek;
	}

	public void setStatistiek(Statistiek statistiek) {
		this.statistiek = statistiek;
	}
	
	public String getVan() {
		return van;
	}

	public void setVan(String van) {
		this.van = van;
	}

	public String getTot() {
		return tot;
	}

	public void setTot(String tot) {
		this.tot = tot;
	}
	
}
