package com.logger;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Log {
	private String title;
	private String author;
	private String log;
	
	private @Id @GeneratedValue long id;
	
	public Log() {
		
	}
	
	public Log(String title, String author, String log) {
		this.title = title;
		this.author = author;
		this.log = log;
	}
	
	
	public long getId() {
		return this.id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
}
