package veilingActions.member;

import veilingActions.DAO.BodDAO;
import veilingActions.DAO.AanbiedingDAO;
import veilingDomain.Bod;

public class Bied {
	
	private BodDAO bodDAO;
	private Bod bod = new Bod(0);
	
	public Bied() {
		bodDAO = new BodDAO();
	}
	
	public String execute() {

	}
	

}
