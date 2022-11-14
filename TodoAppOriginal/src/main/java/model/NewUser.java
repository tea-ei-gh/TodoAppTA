package model;

import java.io.Serializable;

public class NewUser implements Serializable{

	private String newUserId;
	private String newPass;
	private String newMail;
	private String newName;
	
	public NewUser(String newUserId, String newPass, String newMail, String newName) {
		this.newUserId = newUserId;
		this.newPass = newPass;
		this.newMail = newMail;
		this.newName = newName;
	}
	
	public String getNewUserId() {return newUserId;}
	public String getNewPass() {return newPass;}
	public String getNewMail() {return newMail;}
	public String getNewName() {return newName;}
	
	public void setNewUserId(String newUserId) { this.newUserId  = newUserId; }
	public void setNewPass(String newPass) { this.newPass = newPass; }
	public void setNewMai(String newMail) { this.newMail = newMail; }
	public void setNewName(String newName) { this.newName = newName; }

}
