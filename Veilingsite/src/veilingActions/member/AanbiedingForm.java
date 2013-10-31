package veilingActions.member;

import veilingDomain.Aanbieding;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class AanbiedingForm extends ActionSupport{
private int id;
private Aanbieding aanbieding;

public String execute(){
	aanbieding = VeilingService.getAanbieding(id);
	return SUCCESS;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Aanbieding getAanbieding() {
	return aanbieding;
}

public void setAanbieding(Aanbieding aanbieding) {
	this.aanbieding = aanbieding;
}

}
