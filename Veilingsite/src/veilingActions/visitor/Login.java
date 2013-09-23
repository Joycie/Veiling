package veilingActions.visitor;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

import org.apache.struts2.dispatcher.SessionMap;

import veilingActions.DAO.LoginDAO;
import veilingDomain.Gebruiker;

public class Login extends ActionSupport{

	private String email, pass;
	SessionMap<String, String> sessionmap;

	
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
	
	public String execute(){
		if(LoginDAO.validate(email, pass)){
		return SUCCESS;
	}
		else{
			return "error";
		}
	}
}
