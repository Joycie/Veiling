package veilingActions.member;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import veilingDomain.Boek;
import veilingDomain.Categorie;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class BoekInfo extends ActionSupport {
	private ArrayList<Boek> boekenlijst = new ArrayList<Boek>(VeilingService.getBoekenlijst());
	private ArrayList<Categorie> categorielijst = new ArrayList<Categorie>(VeilingService.getCategorielijst());
	private List<Boek> books = new ArrayList<Boek>();
	private List<Categorie> categories = new ArrayList<Categorie>();
	
	public String execute(){
		books = boekenlijst;
		categories = categorielijst;
		System.out.println(books);
		System.out.println(categories);
		return SUCCESS;
	}
	public List<Boek> getBooks() {
		return books;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	
}
