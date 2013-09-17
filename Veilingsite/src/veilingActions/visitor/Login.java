package veilingActions.visitor;
import java.util.Map;
import domein.Gebruiker;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class Login extends ActionSupport{
	private Gebruiker gebruiker;
	@SuppressWarnings("rawtypes")
	private String email, pass;
	private Map session;

	public String execute(){
		
		return SUCCESS;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPass(){
		return pass;
	}
	
	public void setPass(String pass){
		this.pass = pass;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
		
	}
	
}
