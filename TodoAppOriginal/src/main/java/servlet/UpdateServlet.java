package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import dao.UpdateDAO;
import model.Todo;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoId = Integer.parseInt(request.getParameter(Parameters.TODO_ID));

		UpdateDAO dao = new UpdateDAO();
		Todo todo = new Todo();
		try {
			todo = dao.getTodo(todoId);
		} catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		}

		request.setAttribute("todo", todo);
		request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter(Parameters.TODO_ID));
		String text = request.getParameter(Parameters.TODO_TEXT);
		Date timeLimit = Date.valueOf(request.getParameter(Parameters.TIME_LIMIT));

		UpdateDAO dao = new UpdateDAO();
		try {
			dao.updateTodo(id, text, timeLimit);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		response.sendRedirect("/TodoAppOriginal/Main");
	}
}
