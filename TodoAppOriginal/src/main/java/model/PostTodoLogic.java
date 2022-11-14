package model;

import dao.TodoDAO;

public class PostTodoLogic {
	
	public void execute(Todo todo) {
		TodoDAO dao = new TodoDAO();
		dao.create(todo);
	}
	
	
}