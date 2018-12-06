package com.practice.rest.webservices.SpringBootBackEnd.todo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TODO_SEQUENCE")
	@SequenceGenerator(name = "TODO_SEQUENCE", allocationSize = 1)
	private Long id;
	private String username;
	private String Description;

	@Column(name = "TARGET_DATE")
	private Date targetDate;

	@Column(name = "IS_COMPLETED")
	private Boolean isCompleted;

	public Todo() {

	}

	public Todo(Long id, String description, Date targetDate, Boolean isCompleted) {
		super();
		this.id = id;
		Description = description;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Todo other = (Todo) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", Description=" + Description + ", targetDate=" + targetDate + ", isCompleted="
				+ isCompleted + "]";
	}

}
