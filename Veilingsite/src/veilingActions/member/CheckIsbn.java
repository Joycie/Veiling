package veilingActions.member;

import com.opensymphony.xwork2.ActionSupport;

import veilingActions.DAO.CheckIsbnDAO;
import veilingDomain.Boek;
import veilingService.VeilingService;

public class CheckIsbn extends ActionSupport{
	private int isbn;
	
	
	public String execute(){
		if (VeilingService.checkBoek(isbn) == true){
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public int getIsbn(){
		return isbn;
	}
	
	public void setIsbn(int isbn){
		this.isbn = isbn;
	}

}
