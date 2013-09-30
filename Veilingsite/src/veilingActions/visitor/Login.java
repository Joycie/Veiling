package veilingActions.visitor;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

import org.apache.struts2.dispatcher.SessionMap;

import veilingActions.DAO.LoginDAO;
import veilingDomain.Gebruiker;

public class Login extends ActionSupport{

	private String email, pass;
	SessionMap<String, String> sessionmap;
	private LoginDAO logindao;

	public String execute(){
		System.out.println("Test 123" + email);
		Gebruiker geb = LoginDAO.validate(email, pass);
		if(geb != null ){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("gebruiker", geb);
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
	
	public Login(){
		logindao = new LoginDAO();
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
	
}
