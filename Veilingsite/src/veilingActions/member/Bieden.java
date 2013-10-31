package veilingActions.member;

import com.opensymphony.xwork2.ActionSupport;

import veilingActions.DAO.BodDAO;
import veilingActions.DAO.AanbiedingDAO;
import veilingDomain.Bod;
import veilingService.VeilingService;

public class Bieden extends ActionSupport{
	
	private BodDAO bodDAO;
	private Bod bod = new Bod(0);
	
	public Bieden() {
		bodDAO = new BodDAO();
	}
	
	public String execute() {

		return SUCCESS;
	}
	

}
