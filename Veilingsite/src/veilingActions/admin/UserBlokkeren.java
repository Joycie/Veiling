package veilingActions.admin;

import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserBlokkeren extends ActionSupport {
	private Gebruiker gebruiker;
	private int klantnummer;

	public String execute() {
		System.out.println("Klantnummer: " + klantnummer);
		VeilingService.blockUser(klantnummer);
		gebruiker = VeilingService.retrieveUser(klantnummer);
		return SUCCESS;
	}
	public void validate()
	{
		if (gebruiker.getRol() == 2)
		{
			addActionMessage("De gebruiker is al geblokkeerd.");
		}
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

}