package veilingActions.member;


import com.opensymphony.xwork2.ActionSupport;

import veilingService.VeilingService;

public class CheckIsbn extends ActionSupport{
	private String isbn;
	public String execute(){
		if (VeilingService.checkBoek(isbn) == true){
			if (VeilingService.getBoek(isbn) != null){
				return SUCCESS;
			}
			else return INPUT;
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
