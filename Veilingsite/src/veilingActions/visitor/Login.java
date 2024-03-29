package veilingActions.visitor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

import org.apache.struts2.dispatcher.SessionMap;

import veilingActions.DAO.GebruikerDAO;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

public class Login extends ActionSupport {

	private String email, pass;
	SessionMap<String, String> sessionmap;

	public String execute() {

		return ActionSupport.SUCCESS;
	}

	public void validate() {
		email = email.trim();
		pass = pass.trim();
		Gebruiker geb = VeilingService.validateUser(email);
		if (geb != null) {
			if (geb.getRol() != 2) {
				if (geb.getWachtwoord().equals(pass)) {
					Map<String, Object> session = ActionContext.getContext()
							.getSession();
					session.put("gebruiker", geb);
				} else {
					addFieldError("pass",
							"Gebruikersnaam of wachtwoord onjuist");
				}
			} else {
				addFieldError("pass",
						"Deze gebruiker is geblokkeerd. U kunt niet meer inloggen.");
			}

		} else {
			addFieldError("pass",
					"Email en wachtwoord combinatie is niet bekend");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
