package veilingActions.member;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout  extends ActionSupport{
	SessionMap<String, String> sessionmap;
	
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("gebruiker", null);
		return SUCCESS;
	}
}
