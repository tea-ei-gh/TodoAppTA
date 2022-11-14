package model;

import java.io.Serializable;
import java.sql.Date;

public class Todo implements Serializable {
	
	private int id; 
	private String text; 
	private Date timeLimit;
	
	public Todo() {
		id = 0;
		text = "";
		timeLimit = new Date(System.currentTimeMillis());
	}
	
	public Todo( String text, Date timeLimit) {
		this.text = text;
		this.timeLimit = timeLimit;
	}
	
	public Todo(int id, String text, Date timeLimit) {
		this.id = id ;
		this.text = text ;
		this.timeLimit = timeLimit;
	}
	
	public int getId() { return id ; }
	public String getText() {return text;}
	public Date getTimeLimit() {return timeLimit;}
	
	public void setId(int id) { this.id=id; }
	public void setText(String text) { this.text=text; }
	public void setTimeLimit(Date timeLimit) { this.timeLimit=timeLimit; }
	
}