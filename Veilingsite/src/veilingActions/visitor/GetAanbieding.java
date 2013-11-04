package veilingActions.visitor;
import java.util.ArrayList;

import veilingDomain.Aanbieding;
import veilingDomain.Bod;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;
import com.opensymphony.xwork2.ActionSupport;

public class GetAanbieding extends ActionSupport {
	private int id;
	private Aanbieding aanbieding;
	private ArrayList<Bod> biedingen = new ArrayList<Bod>();
	
	public ArrayList<Bod> getBiedingen() {
		return biedingen;
	}

	public void setBiedingen(ArrayList<Bod> biedingen) {
		this.biedingen = biedingen;
	}

	public String execute() {
		aanbieding = VeilingService.getAanbieding(id);
		biedingen = VeilingService.getBiedingenById(id);
		return SUCCESS;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aanbieding getAanbieding() {
		return aanbieding;
	}

	public void setAanbieding(Aanbieding aanbieding) {
		this.aanbieding = aanbieding;
	}

	public int getId() {
		return id;
	}
}
