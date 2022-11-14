package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Todo;

public class UpdateDAO {

	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/Desktop/javaWorkSpace/todoList2";
	private final String DB_USER = "sa";
	private final String DB_PASS = "1017";
	
	public Todo getTodo(int id) throws SQLException, ClassNotFoundException {
		Todo todo = new Todo();

		String sql = "SELECT id, text, timeLimit FROM todo_a WHERE id = ? ";

		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				todo.setId(res.getInt("id"));
				todo.setText(res.getString("text"));
				todo.setTimeLimit(res.getDate("timeLimit"));
			}
		}
		return todo;
	}
	
	public int updateTodo(int id, String text, Date timeLimit) throws SQLException, ClassNotFoundException {
		
		int processingNumber = 0;

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE ");
		sql.append("    todo_A ");
		sql.append(" SET ");
		sql.append("    text = ? ");
		sql.append(",   timeLimit = ? ");
		sql.append(" WHERE ");
		sql.append("    id = ? ");

		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = con.prepareStatement(sql.toString())) {
			pstmt.setString(1, text);
			pstmt.setDate(2, timeLimit);
			pstmt.setInt(3, id);

			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}