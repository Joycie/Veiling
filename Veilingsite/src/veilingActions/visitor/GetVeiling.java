package veilingActions.visitor;
import veilingDomain.Aanbieding;
import veilingService.VeilingService;
import com.opensymphony.xwork2.ActionSupport;

public class GetVeiling extends ActionSupport {
	private String id;
	
	public String execute() {
		Aanbieding aanbieding = VeilingService.getAanbieding(id);
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
