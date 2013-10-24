package veilingActions.visitor;

import java.util.ArrayList;

import veilingActions.DAO.GetVeilingenDAO;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class GetVeilingen extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ArrayList<Aanbieding> veilingen = new ArrayList<Aanbieding>();
	private ArrayList<Aanbieding> recenteveilingen = new ArrayList<Aanbieding>();
	private ArrayList<Boek> boeken = new ArrayList<Boek>();

	public String execute() {
		VeilingService.retrieveVeilingen();

		veilingen = VeilingService.getVeilingenlijst();
		recenteveilingen = VeilingService.getRecenteveilingen();

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
	
}