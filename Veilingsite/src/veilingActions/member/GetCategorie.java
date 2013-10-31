package veilingActions.member;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import veilingDomain.Boek;
import veilingDomain.Categorie;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class GetCategorie extends ActionSupport {
	private ArrayList<Categorie> categorielijst = new ArrayList<Categorie>(VeilingService.getCategorielijst());
	private List<Categorie> categories = new ArrayList<Categorie>();
	
	public String execute(){
		categories = categorielijst;
		return SUCCESS;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	
}
