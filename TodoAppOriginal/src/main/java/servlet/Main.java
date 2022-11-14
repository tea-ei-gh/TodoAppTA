package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.Parameters;
import model.GetTodoListLogic;
import model.LoginIP;
import model.PostTodoLogic;
import model.Todo;

@WebServlet("/Main")
public class Main extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	 
	 GetTodoListLogic getTodoListLogic = new GetTodoListLogic();
	 List<Todo> todoList = getTodoListLogic.execute();
	 request.setAttribute("todoList", todoList);
	 
	 HttpSession session = request.getSession();
     LoginIP loginUser = (LoginIP) session.getAttribute("loginUser");
     
     if(loginUser == null){ 
    		 response.sendRedirect("/TodoAppOriginal/");
    	 } else { 
    		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
    		 dispatcher.forward(request, response);
    	 	}
  	} 
  
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	 
	  request.setCharacterEncoding("UTF-8");
	  String text = request.getParameter(Parameters.TODO_TEXT);
	  Date timeLimit = Date.valueOf(request.getParameter(Parameters.TIME_LIMIT));
	  
	  if(text != null && text.length() != 0 && timeLimit != null) {
		 
		Todo todo = new Todo(text, timeLimit);
		  PostTodoLogic postTodoLogic = new PostTodoLogic();
		  postTodoLogic.execute(todo);
		 
	  } else { 
		  request.setAttribute("errorMsg", "※Todoが入力されていません※");
	  	}	
	  
	  GetTodoListLogic getTodoListLogic = new GetTodoListLogic();
	  List<Todo> todoList = getTodoListLogic.execute();
	  request.setAttribute("todoList", todoList);
	  
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
	  dispatcher.forward(request, response);
  }
  
}
