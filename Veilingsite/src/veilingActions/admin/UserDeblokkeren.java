package veilingActions.admin;

import veilingDomain.Gebruiker;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserDeblokkeren extends ActionSupport {
	private Gebruiker gebruiker;
	private int klantnummer;

	public String execute() {
		System.out.println("Klantnummer: " + klantnummer);
		VeilingService.deblockUser(klantnummer);
		gebruiker = VeilingService.retrieveUser(klantnummer);
		return SUCCESS;
	}
	public void validate()
	{
		if (klantnummer == 0 || klantnummer == 1)
		{
			addActionMessage("De gebruiker is niet geblokkeerd.");
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