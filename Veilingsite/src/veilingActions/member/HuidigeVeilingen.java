package veilingActions.member;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import veilingActions.DAO.VeilingDAO;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;

public class HuidigeVeilingen extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private VeilingDAO veilingdao;
	private ArrayList<Aanbieding> veilingen = new ArrayList<Aanbieding>();
	private ArrayList<Boek> boeken = new ArrayList<Boek>();
	
	public String execute(){
		Aanbieding aanb = VeilingDAO.validate();
		if(aanb != null ){
			veilingen = VeilingDAO.getVeilingenlijst();
		}
		return SUCCESS;
	}
	public HuidigeVeilingen()
	{
		veilingdao = new VeilingDAO();
	}
	public VeilingDAO getVeilingdao() {
		return veilingdao;
	}

	public void setVeilingdao(VeilingDAO veilingdao) {
		this.veilingdao = veilingdao;
	}
	public ArrayList<Aanbieding> getVeilingen() {
		return veilingen;
	}
	public void setVeilingen(ArrayList<Aanbieding> veilingen) {
		this.veilingen = veilingen;
	}
	public ArrayList<Boek> getBoeken() {
		return boeken;
	}
	public void setBoeken(ArrayList<Boek> boeken) {
		this.boeken = boeken;
	}
}
