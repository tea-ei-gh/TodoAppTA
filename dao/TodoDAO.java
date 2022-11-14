package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class TodoDAO {
	
	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/Desktop/javaWorkSpace/todoList2";
	private final String DB_USER = "sa";
	private final String DB_PASS = "1017";
	
	public List<Todo> findAll(){
		List<Todo> todoList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "SELECT ID, TEXT, TIMELIMIT FROM TODO_A ORDER BY ID DESC"; 
			
			PreparedStatement pSmt = conn.prepareStatement(sql);
			
			ResultSet rs = pSmt.executeQuery();
			
			while ( rs.next() ) {
				int id = rs.getInt("ID");
				String text = rs.getString("TEXT");
				Date timeLimit = rs.getDate("TIMELIMIT");
				Todo todo = new Todo(id, text, timeLimit);
				todoList.add(todo);
			}
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return todoList;
	}
	public boolean create(Todo todo) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "INSERT INTO TODO_A( TEXT, TIMELIMIT) VALUES(?, ?)";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			
			pSmt.setString(1, todo.getText() );
			pSmt.setDate(2, todo.getTimeLimit() );
			
			int result = pSmt.executeUpdate();
			if(result != 1) {
				return false; 
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}