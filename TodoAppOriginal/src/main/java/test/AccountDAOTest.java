package test;

import dao.AccountDAO;
import model.Account;
import model.LoginIP;

public class AccountDAOTest {
  public static void main(String[] args) {
    testFindByLogin1(); 
    testFindByLogin2(); 
  }

  public static void testFindByLogin1() {
    LoginIP loginIP = new LoginIP("tarou", "5678");
    AccountDAO dao = new AccountDAO();
    Account result = dao.findByLogin(loginIP);
    if (result != null &&
    	result.getUserId().equals("tarou") && 
    	result.getPass().equals("5678") &&
        result.getMail().equals("tarou@sukkiri.com") &&
        result.getName().equals("田中太郎")) {
      System.out.println("findByLogin1:成功しました");
    } else {
      System.out.println("findByLogin1:失敗しました");
    }
  }

  public static void testFindByLogin2() {
    LoginIP loginIP = new LoginIP("minato", "12345");
    AccountDAO dao = new AccountDAO();
    Account result = dao.findByLogin(loginIP);
    if (result == null) {
      System.out.println("findByLogin2:成功しました");
    } else {
      System.out.println("findByLogin2:失敗しました");
    }
  }
}