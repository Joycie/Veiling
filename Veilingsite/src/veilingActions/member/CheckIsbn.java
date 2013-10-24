package veilingActions.member;


import com.opensymphony.xwork2.ActionSupport;

import veilingService.VeilingService;

public class CheckIsbn extends ActionSupport{
	private String isbn;
	public String execute(){
		if (VeilingService.checkBoek(isbn) == true){
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}

}
