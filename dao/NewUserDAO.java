package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.NewUser;

public class NewUserDAO {

	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/Desktop/javaWorkSpace/todoList2";
	private final String DB_USER = "sa";
	private final String DB_PASS = "1017";
	
	public boolean create(NewUser newUser) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "insert into ACCOUNT (USER_ID, PASS, MAIL, NAME) VALUES(?, ?, ?, ?)";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			
			pSmt.setString(1, newUser.getNewUserId() );
			pSmt.setString(2, newUser.getNewPass() );
			pSmt.setString(3, newUser.getNewMail() );
			pSmt.setString(4, newUser.getNewName() );
			
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
