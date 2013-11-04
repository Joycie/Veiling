package veilingActions.member;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import veilingActions.DAO.BodDAO;
import veilingActions.DAO.AanbiedingDAO;
import veilingActions.visitor.GetAanbieding;
import veilingDomain.Aanbieding;
import veilingDomain.Bod;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

public class Bieden extends ActionSupport implements SessionAware{
	
	private BodDAO bodDAO;
	private Bod bod = new Bod(0);
	private GetAanbieding getAanbieding;
	private Gebruiker gebruiker;
	private int id;
	private double bid;
	private SessionMap session;
	SessionMap<String, String> sessionmap;
	
	public Bieden() {
		bodDAO = new BodDAO();
	}
	
	public String execute() {
		Aanbieding aanbieding = VeilingService.getAanbieding(id);
		Gebruiker gebruiker = (Gebruiker) session.get("gebruiker");
		if (gebruiker == null) {
			addActionMessage("U moet ingelogd zijn om te mogen bieden");
			return INPUT;
		}
		if (gebruiker.getKlantnummer() == aanbieding.getGebruikers_klantnr()){
			addActionMessage("U kunt niet op eigen veiling bieden");
			return INPUT;
		}
		if (bid == 0){
			addActionMessage("U moet een bedrag invullen");
			return INPUT;
		}
		if (bid <= aanbieding.getStartprijs() || bid <= VeilingService.getEindprijs(id)) {
			addActionMessage("Het bod moet hoger zijn");
			return INPUT;
		}
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Timestamp biedtijd = new java.sql.Timestamp(currentDate.getTime());
		Bod bod = new Bod(biedtijd, gebruiker.getKlantnummer(), aanbieding.getId(), bid);
		if (VeilingService.bieden(bod)){
			addActionMessage("Bieden gelukt");
			return SUCCESS;
		}
		else {
			addActionMessage("Bieden niet gelukt");
			return INPUT;
		}
		
	}

	
	//getters en setters
	
	public BodDAO getBodDAO() {
		return bodDAO;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public void setBodDAO(BodDAO bodDAO) {
		this.bodDAO = bodDAO;
	}

	public Bod getBod() {
		return bod;
	}

	public void setBod(Bod bod) {
		this.bod = bod;
	}

	public GetAanbieding getGetAanbieding() {
		return getAanbieding;
	}

	public void setGetAanbieding(GetAanbieding getAanbieding) {
		this.getAanbieding = getAanbieding;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap) session;
	}

}