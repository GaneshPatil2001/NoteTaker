package com.entities;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.*;

@Entity
@Table(name="tblnotes")
public class NoteTaker {
	@Id
	private int id;
	private String title;
	@Column(length=2000)
	private String content;
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public NoteTaker(String title, String content, Date addedDate) {
		super();
		this.id = new Random().nextInt(100000);
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}
	public NoteTaker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
