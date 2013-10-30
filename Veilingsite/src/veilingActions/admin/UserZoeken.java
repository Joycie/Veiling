package veilingActions.admin;
import java.util.ArrayList;
import java.util.List;

import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserZoeken extends ActionSupport {
	private Gebruiker gebruiker;
	private int klantnummer;
	
	public String execute() {
		VeilingService.retrieveUser(klantnummer);

		return SUCCESS;
	}

}