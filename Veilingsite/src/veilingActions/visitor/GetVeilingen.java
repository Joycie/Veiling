package veilingActions.visitor;

import java.sql.Timestamp;
import java.util.ArrayList;

import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class GetVeilingen extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ArrayList<Aanbieding> veilingen = new ArrayList<Aanbieding>();
	private ArrayList<Aanbieding> recenteveilingen = new ArrayList<Aanbieding>();
	private ArrayList<Boek> boeken = new ArrayList<Boek>();
	private int categorie;
	private Timestamp sysdate;
	
	public String execute() {
		java.util.Date date = new java.util.Date();
		sysdate = new Timestamp(date.getTime());
		sysdate.setDate(sysdate.getDate() - 1);
		String stringCategorie = Integer.toString(categorie);
		VeilingService.retrieveVeilingen(stringCategorie);

		veilingen = VeilingService.getVeilingenlijst();
		return SUCCESS;
	}

	public ArrayList<Aanbieding> getVeilingen() {
		return veilingen;
	}

	public void setVeilingen(ArrayList<Aanbieding> veilingen) {
		this.veilingen = veilingen;
	}

	public ArrayList<Boek> getBoeken() {
		return boeken;
	}

	public void setBoeken(ArrayList<Boek> boeken) {
		this.boeken = boeken;
	}

	public ArrayList<Aanbieding> getRecenteveilingen() {
		return recenteveilingen;
	}

	public void setRecenteveilingen(ArrayList<Aanbieding> recenteveilingen) {
		this.recenteveilingen = recenteveilingen;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public Timestamp getSysdate() {
		return sysdate;
	}

	public void setSysdate(Timestamp sysdate) {
		this.sysdate = sysdate;
	}
	
	
}
