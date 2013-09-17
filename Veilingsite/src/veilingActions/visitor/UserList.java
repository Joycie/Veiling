package veilingActions.visitor;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domein.Gebruiker;

@SuppressWarnings("serial")
public class UserList extends ActionSupport {
	private List<Gebruiker> gebruikers = new ArrayList<Gebruiker>();

	public String execute() {

		return ActionSupport.SUCCESS;
	}

	public List<Gebruiker> getGebruikers() {
		return gebruikers;
	}
}