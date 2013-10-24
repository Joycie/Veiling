package veilingDomain;


public class Categorie {
	private int id;
	private String naam;
	
	public Categorie(int id, String nm) {
		this.id = id;
		naam = nm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
}
