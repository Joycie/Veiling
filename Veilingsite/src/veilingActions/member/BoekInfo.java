package veilingActions.member;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import veilingDomain.Boek;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class BoekInfo extends ActionSupport {
	private ArrayList<Boek> boekenlijst = new ArrayList<Boek>(VeilingService.getBoekenlijst());
	private List<Boek> books = new ArrayList<Boek>();

	public String execute(){
		books = boekenlijst;
		System.out.println(books);
		return SUCCESS;
	}
	public List<Boek> getBooks() {
		return books;
	}
}
