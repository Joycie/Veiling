package veilingActions.admin;

import veilingDomain.Aanbieding;
import veilingDomain.Statistiek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class GetStatistieken extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Statistiek statistiek;
	private Aanbieding aanbieding;
	
	public String execute() {
		statistiek = VeilingService.retrieveStatistieken();	

		return SUCCESS;
	}

	public Statistiek getStatistiek() {
		return statistiek;
	}

	public void setStatistiek(Statistiek statistiek) {
		this.statistiek = statistiek;
	}
	
}
