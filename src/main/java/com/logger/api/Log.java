package com.logger.api;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Log {
	private String title;
	private String author;
	private String log;
	private Date date;
	private Date editDate;
	private @Id @GeneratedValue long id;
	
	public Log() {
		
	}
	
	public Log(String title, String author, String log,Date date) {
		this.title = title;
		this.author = author;
		this.log = log;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
}
