package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginIP;
import model.LoginLogic;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	
  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
	  request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userId");
    String pass = request.getParameter("pass");
    
    LoginIP loginIP = new LoginIP(userId, pass);
    LoginLogic bo = new LoginLogic();
    boolean result = bo.execute(loginIP);
    
    if(result) {
    	HttpSession session = request.getSession();
    	session.setAttribute("loginUser", loginIP);	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
    	dispatcher.forward(request, response);
    } 
    else {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginNO.jsp");
     	dispatcher.forward(request, response);
	  }
    
  }
}