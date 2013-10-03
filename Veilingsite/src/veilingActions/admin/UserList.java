package veilingActions.admin;
import java.util.ArrayList;
import java.util.List;

import veilingActions.DAO.UserListDAO;
import veilingDomain.Gebruiker;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserList extends ActionSupport {
	private ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
	private UserListDAO userlistdao;

	public String execute() {
		Gebruiker gebruiker = UserListDAO.validate();
		gebruikerslijst = UserListDAO.getGebruikerslijst();	

		return SUCCESS;
	}

	public UserList()
	{
		userlistdao = new UserListDAO();
	}
	public List<Gebruiker> getGebruikerslijst() {
		return gebruikerslijst;
	}

	public UserListDAO getUserlistdao() {
		return userlistdao;
	}

	public void setUserlistdao(UserListDAO userlistdao) {
		this.userlistdao = userlistdao;
	}

	public void setGebruikerslijst(ArrayList<Gebruiker> gebruikerslijst) {
		this.gebruikerslijst = gebruikerslijst;
	}
}