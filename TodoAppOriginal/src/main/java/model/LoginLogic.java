package model;

import dao.AccountDAO;

public class LoginLogic {
	
	public boolean execute(LoginIP loginIP) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(loginIP);
		return account != null ;
	}

}




