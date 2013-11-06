package veilingDomain;

import java.util.ArrayList;

public class Statistiek {
	private Aanbieding aanbieding;
	private int aantalgebruikers, totaalaantalaanbiedingen,
			aantallopendeaanbiedingen, aantalboeken;
	private double hoogstebod_dag, hoogstebod_week, hoogstebod_maand, hoogstebod_jaar, hoogstekrediet, hoogstekredietopwaardering,
			totaleomzet;
	private ArrayList<BiedingenStatistiek> biedingen = new ArrayList<BiedingenStatistiek>();
	

	public Statistiek(Aanbieding aanbieding, int aantalgebruikers,
			int totaalaantalaanbiedingen, int aantallopendeaanbiedingen,
			int aantalboeken, double hoogstebod_dag, double hoogstebod_week, double hoogstebod_maand, double hoogstebod_jaar, double hoogstekrediet,
			double hoogstekredietopwaardering, double totaleomzet) {
		this.aanbieding = aanbieding;
		this.aantalgebruikers = aantalgebruikers;
		this.totaalaantalaanbiedingen = totaalaantalaanbiedingen;
		this.aantallopendeaanbiedingen = aantallopendeaanbiedingen;
		this.aantalboeken = aantalboeken;
		this.hoogstebod_dag = hoogstebod_dag;
		this.hoogstebod_week = hoogstebod_week;
		this.hoogstebod_maand = hoogstebod_maand;
		this.hoogstebod_jaar = hoogstebod_jaar;
		this.hoogstekrediet = hoogstekrediet;
		this.hoogstekredietopwaardering = hoogstekredietopwaardering;
		this.totaleomzet = totaleomzet;
	}

	public int getAantalgebruikers() {
		return aantalgebruikers;
	}

	public void setAantalgebruikers(int aantalgebruikers) {
		this.aantalgebruikers = aantalgebruikers;
	}

	public int getTotaalaantalaanbiedingen() {
		return totaalaantalaanbiedingen;
	}

	public void setTotaalaantalaanbiedingen(int totaalaantalaanbiedingen) {
		this.totaalaantalaanbiedingen = totaalaantalaanbiedingen;
	}

	public int getAantalboeken() {
		return aantalboeken;
	}

	public void setAantalboeken(int aantalboeken) {
		this.aantalboeken = aantalboeken;
	}
	

	public double getHoogstebod_dag() {
		return hoogstebod_dag;
	}

	public void setHoogstebod_dag(double hoogstebod_dag) {
		this.hoogstebod_dag = hoogstebod_dag;
	}

	public double getHoogstebod_week() {
		return hoogstebod_week;
	}

	public void setHoogstebod_week(double hoogstebod_week) {
		this.hoogstebod_week = hoogstebod_week;
	}

	public double getHoogstebod_maand() {
		return hoogstebod_maand;
	}

	public void setHoogstebod_maand(double hoogstebod_maand) {
		this.hoogstebod_maand = hoogstebod_maand;
	}

	public double getHoogstebod_jaar() {
		return hoogstebod_jaar;
	}

	public void setHoogstebod_jaar(double hoogstebod_jaar) {
		this.hoogstebod_jaar = hoogstebod_jaar;
	}

	public double getHoogstekrediet() {
		return hoogstekrediet;
	}

	public void setHoogstekrediet(double hoogstekrediet) {
		this.hoogstekrediet = hoogstekrediet;
	}

	public double getHoogstekredietopwaardering() {
		return hoogstekredietopwaardering;
	}

	public void setHoogstekredietopwaardering(double hoogstekredietopwaardering) {
		this.hoogstekredietopwaardering = hoogstekredietopwaardering;
	}

	public double getTotaleomzet() {
		return totaleomzet;
	}

	public void setTotaleomzet(double totaleomzet) {
		this.totaleomzet = totaleomzet;
	}

	public Aanbieding getAanbieding() {
		return aanbieding;
	}

	public void setAanbieding(Aanbieding aanbieding) {
		this.aanbieding = aanbieding;
	}

	public int getAantallopendeaanbiedingen() {
		return aantallopendeaanbiedingen;
	}

	public void setAantallopendeaanbiedingen(int aantallopendeaanbiedingen) {
		this.aantallopendeaanbiedingen = aantallopendeaanbiedingen;
	}

}
