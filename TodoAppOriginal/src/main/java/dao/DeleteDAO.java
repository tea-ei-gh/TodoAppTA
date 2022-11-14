package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {

	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/Desktop/javaWorkSpace/todoList2";
	private final String DB_USER = "sa";
	private final String DB_PASS = "1017";
	
	public int deleteTodo(int id) throws SQLException, ClassNotFoundException {
		
		int processingNumber = 0;

		String sql = "DELETE FROM todo_A WHERE id = ?";

		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}