package veilingActions.member;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import veilingActions.DAO.VeilingDAO;
import veilingDomain.Aanbieding;
import veilingDomain.Boek;

public class HuidigeVeilingen extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	private double startprijs;
	private Date eindtijd;
	private VeilingDAO veilingdao;
	private static ArrayList<Aanbieding> veilingen = new ArrayList<Aanbieding>();
	
	public String execute(){
		System.out.println("ID: " + id + "|| startprijs: " + startprijs + "|| Eindtijd: " + eindtijd);
		Aanbieding aanb = VeilingDAO.validate();
		if(aanb != null ){
			veilingen = VeilingDAO.getVeilingenlijst();
			System.out.println(veilingen);
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
	public HuidigeVeilingen()
	{
		veilingdao = new VeilingDAO();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getStartprijs() {
		return startprijs;
	}

	public void setStartprijs(double startprijs) {
		this.startprijs = startprijs;
	}

	public Date getEindtijd() {
		return eindtijd;
	}

	public void setEindtijd(Date eindtijd) {
		this.eindtijd = eindtijd;
	}

	public VeilingDAO getVeilingdao() {
		return veilingdao;
	}

	public void setVeilingdao(VeilingDAO veilingdao) {
		this.veilingdao = veilingdao;
	}

	public static ArrayList<Aanbieding> getVeilingen() {
		return veilingen;
	}

	public static void setVeilingen(ArrayList<Aanbieding> veilingen) {
		HuidigeVeilingen.veilingen = veilingen;
	}
	
}
