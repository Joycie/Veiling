package veilingActions.admin;
import java.util.ArrayList;
import java.util.List;

import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserList extends ActionSupport {
	private ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();

	public String execute() {
		VeilingService.validateUserList("");
		gebruikerslijst = VeilingService.getGebruikerslijst();	

		return SUCCESS;
	}
	public List<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}

	public void setGebruikerslijst(ArrayList<Gebruiker> gebruikerslijst) {
		this.gebruikerslijst = gebruikerslijst;
	}
}