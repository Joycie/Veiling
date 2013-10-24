package veilingDomain;

import java.util.Date;

public class Bod {
	
	  private int id;
	  private Date datumTijd;
	  private Gebruiker gebruiker;
	  private Aanbieding aanbieding;
	  private double geld;
	  
	  public Bod(int id, Date datumTijd, Gebruiker gebruiker, Aanbieding aanbieding, double geld) {
		this.id = id;
		this.datumTijd = datumTijd;
		this.gebruiker = gebruiker;
		this.aanbieding = aanbieding;
		this.geld = geld;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumTijd() {
		return datumTijd;
	}

	public void setDatumTijd(Date datumTijd) {
		this.datumTijd = datumTijd;
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public Aanbieding getAanbieding() {
		return aanbieding;
	}

	public void setAanbieding(Aanbieding aanbieding) {
		this.aanbieding = aanbieding;
	}

	public double getGeld() {
		return geld;
	}

	public void setGeld(double geld) {
		this.geld = geld;
	}
	  
	  

}
