package veilingActions.member;

import veilingDomain.Aanbieding;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class VeilingVerwijderen extends ActionSupport  {
	private int id;
	
	public String execute(){
		Aanbieding aanbieding = new Aanbieding(id, 0, null, 0, null, 0, null);
		VeilingService.deleteAanbieding(aanbieding);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
