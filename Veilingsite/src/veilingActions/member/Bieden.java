package veilingActions.member;

import java.sql.Timestamp;
import java.util.ArrayList;
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

public class Bieden extends ActionSupport implements SessionAware {

	private BodDAO bodDAO;
	private Bod bod = new Bod(0);
	private GetAanbieding getAanbieding;
	private Gebruiker gebruiker;
	private int id;
	private double guldens;
	private SessionMap session;
	private Aanbieding aanbieding;
	private ArrayList<Bod> biedingen = new ArrayList<Bod>();
	SessionMap<String, String> sessionmap;

	public Bieden() {
		bodDAO = new BodDAO();
		
	}

	public String execute() {
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Timestamp biedtijd = new java.sql.Timestamp(
				currentDate.getTime());
		Bod bod = new Bod(biedtijd, gebruiker.getKlantnummer(),
				aanbieding.getId(), guldens);

		if (VeilingService.bieden(bod)) {
			addActionMessage("Bieden gelukt");
			if (VeilingService.kredietInleveren(gebruiker.getKlantnummer(),
					gebruiker.getKrediet() - guldens)) {
				gebruiker.setKrediet(gebruiker.getKrediet() - guldens);
				session.put("gebruiker", gebruiker);
				aanbieding = VeilingService.getAanbieding(id);
				biedingen = VeilingService.getBiedingenById(id);
				return SUCCESS;
			} 
		} else {
			addActionError("Bieden niet gelukt");
			return INPUT;
		}
		return SUCCESS;
	}

	public void validate() {
		Gebruiker gebruiker = (Gebruiker) session.get("gebruiker");
		aanbieding = VeilingService.getAanbieding(id);
		biedingen = VeilingService.getBiedingenById(id);
		if (gebruiker.getKrediet() < guldens) {
			addActionError("U heeft niet genoeg gulden, u komt ƒ " + (guldens-gebruiker.getKrediet()) + " te kort.");
		}
		if (gebruiker.getKlantnummer() == aanbieding.getGebruikers_klantnr()) {
			addActionError("U kunt niet op eigen veiling bieden");
		}
		if (guldens < 1) {
			addActionError("U moet een bedrag invullen van minimaal ƒ 1.0");
		}
		if (guldens <= aanbieding.getStartprijs()
				|| guldens <= aanbieding.getBod().getBedrag()) {
			addActionError("Het bod moet hoger zijn dan het huidige bod.");

		}
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		java.sql.Timestamp biedtijd = new java.sql.Timestamp(date.getTime());
		Aanbieding aanbieding = VeilingService.getAanbieding(id);
		if (aanbieding.getEindtijd().getTime() - 10000 < biedtijd.getTime()) {
			aanbieding.getEindtijd().setSeconds(
					aanbieding.getEindtijd().getSeconds() + 15);
			VeilingService.updateEindtijdAanbieding(aanbieding);
		}
	}

	// getters en setters

	public BodDAO getBodDAO() {
		return bodDAO;
	}

	public double getGuldens() {
		return guldens;
	}

	public void setGuldens(double guldens) {
		this.guldens = guldens;
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

	public Aanbieding getAanbieding() {
		return aanbieding;
	}

	public void setAanbieding(Aanbieding aanbieding) {
		this.aanbieding = aanbieding;
	}

	public ArrayList<Bod> getBiedingen() {
		return biedingen;
	}

	public void setBiedingen(ArrayList<Bod> biedingen) {
		this.biedingen = biedingen;
	}
	
}
