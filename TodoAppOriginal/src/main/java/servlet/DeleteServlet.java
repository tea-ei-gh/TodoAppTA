package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import dao.DeleteDAO;
import dao.UpdateDAO;
import model.Todo;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
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
		request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int todoId = Integer.parseInt(request.getParameter(Parameters.TODO_ID));

		DeleteDAO dao = new DeleteDAO();
		try {
			dao.deleteTodo(todoId);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/TodoAppOriginal/Main");/* ? */
	}

}
