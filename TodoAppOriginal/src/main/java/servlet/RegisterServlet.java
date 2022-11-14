package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NewUser;
import model.PostNewUserLogic;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action==null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}
		else if(action.equals("done")){
			HttpSession session = request.getSession();
	    	NewUser newUser = (NewUser) session.getAttribute("newUser");
	    	session.setAttribute("newUser", newUser);
		    
	    	PostNewUserLogic pnul = new PostNewUserLogic();
	    	pnul.execute(newUser);
	    	
	    	session.removeAttribute("newUser");
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerComp.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	    String newUserId = request.getParameter("newUserId");
	    String newPass = request.getParameter("newPass");
	    String newMail = request.getParameter("newMail");
	    String newName = request.getParameter("newName");
	    
	    if(newUserId != null && newUserId.length() != 0 
	    	&& newPass != null && newPass.length() != 0
	    	&& newMail != null && newMail.length() != 0
	    	&& newMail != null && newName.length() != 0) {
	    	
	    	NewUser newUser = new NewUser(newUserId, newPass, newMail, newName);
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("newUser", newUser);
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
			dispatcher.forward(request, response);
	   
	    } else { 
			request.setAttribute("errorMsgR", "※入力されていない項目があります※");
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
	  	  	dispatcher.forward(request, response);
		  }
	}
}

