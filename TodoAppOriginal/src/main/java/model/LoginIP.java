package model;

import java.io.Serializable;

public class LoginIP implements Serializable{
  private String userId;
  private String pass;

  public LoginIP(String userId, String pass) {
    this.userId = userId;
    this.pass = pass;
  }

  public String getUserId() {
    return userId;
  }

  public String getPass() {
    return pass;
  }
  
  public LoginIP() {}  
}
