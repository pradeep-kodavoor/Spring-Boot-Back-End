package com.practice.rest.webservices.SpringBootBackEnd;

import java.util.Date;

public class Todo {

	private int id;
	private String Description;
	private Date targetDate;
	private Boolean isCompleted;

	public Todo(int id, String description, Date targetDate, Boolean isCompleted) {
		super();
		this.id = id;
		Description = description;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", Description=" + Description + ", targetDate=" + targetDate + ", isCompleted="
				+ isCompleted + "]";
	}

}