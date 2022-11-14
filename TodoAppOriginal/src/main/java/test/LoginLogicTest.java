package test;

import model.LoginIP;
import model.LoginLogic;

public class LoginLogicTest {
	
	public static void main(String[] args) {
		testExecute1();
		testExecute2();
	}
	
	public static void testExecute1() {
		LoginIP loginIP = new LoginIP("tarou", "5678");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(loginIP);
		if(result) {
			System.out.println("testExecute1：成功しました");
		} else {
			System.out.println("testExecute1：失敗しました");
		}
	}
	
	public static void testExecute2() {
		LoginIP loginIP = new LoginIP("minato", "12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(loginIP);
		if(!result) {
			System.out.println("testExecute2：成功しました");
		} else {
			System.out.println("testExecute2：失敗しました");
		}
	}
}