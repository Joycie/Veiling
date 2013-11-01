package veilingActions.member;

import com.opensymphony.xwork2.ActionSupport;
import veilingActions.DAO.BodDAO;
import veilingActions.DAO.AanbiedingDAO;
import veilingActions.visitor.GetAanbieding;
import veilingDomain.Bod;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

public class Bieden extends ActionSupport{
	
	private static final String veilingId = null;
	private BodDAO bodDAO;
	private Bod bod = new Bod(0);
	private GetAanbieding getAanbieding;
	private Gebruiker gebruiker;
	
	public Bieden() {
		bodDAO = new BodDAO();
	}
	
	public String execute() {
		getAanbieding = (GetAanbieding) AanbiedingDAO.findById(veilingId);
		if (gebruiker == null) {
			addFieldError("ingelogd", "U moet ingelogd zijn om te mogen bieden");
			return INPUT;
		}
		

		
		
		
		
		return SUCCESS;
	}
	

}
