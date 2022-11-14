package model;

import dao.NewUserDAO;

public class PostNewUserLogic {
	
	public void execute(NewUser newUser) {
		NewUserDAO dao = new NewUserDAO();
		dao.create(newUser);
	}

}
