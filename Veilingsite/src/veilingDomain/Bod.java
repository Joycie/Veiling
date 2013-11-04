package veilingDomain;

import java.sql.Timestamp;

public class Bod {

	private Timestamp datumTijd;
	private int klantnr;
	private int aanbiedingid;
	private double bedrag;
	private Gebruiker bieder;

	public Bod(Timestamp datumTijd, int klantnr, int aanbiedingid, double bedrag) {
		this.datumTijd = datumTijd;
		this.klantnr = klantnr;
		this.aanbiedingid = aanbiedingid;
		this.bedrag = bedrag;
	}

	public Bod(Timestamp datumTijd, int klantnr, int aanbiedingid,
			double bedrag, Gebruiker bieder) {
		this.datumTijd = datumTijd;
		this.klantnr = klantnr;
		this.aanbiedingid = aanbiedingid;
		this.bedrag = bedrag;
		this.bieder = bieder;
	}

	public Bod(double bedrag) {
		this.bedrag = bedrag;
	}

	public Timestamp getDatumTijd() {
		return datumTijd;
	}

	public void setDatumTijd(Timestamp datumTijd) {
		this.datumTijd = datumTijd;
	}

	public int getKlantnr() {
		return klantnr;
	}

	public void setKlantnr(int klantnr) {
		this.klantnr = klantnr;
	}

	public int getAanbiedingid() {
		return aanbiedingid;
	}

	public void setAanbiedingid(int aanbiedingid) {
		this.aanbiedingid = aanbiedingid;
	}

	public double getBedrag() {
		return bedrag;
	}

	public void setBedrag(double bedrag) {
		this.bedrag = bedrag;
	}

	public Gebruiker getBieder() {
		return bieder;
	}

	public void setBieder(Gebruiker bieder) {
		this.bieder = bieder;
	}

}
