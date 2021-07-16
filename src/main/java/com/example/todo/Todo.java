package com.example.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    
    private String title;

    @Size(min = 10, message = "Enter at least 10 Characters...")
    private String description;
    
    private  String link;

    private Date targetDate;

    public Todo() {
        super();
    }

	public Todo(long id, String email, String title,
			@Size(min = 10, message = "Enter at least 10 Characters...") String description, String link,
			Date targetDate) {
		super();
		this.id = id;
		this.email = email;
		this.title = title;
		this.description = description;
		this.link = link;
		this.targetDate = targetDate;
	}
	
	public Todo(String email, String title,
			@Size(min = 10, message = "Enter at least 10 Characters...") String description, String link,
			Date targetDate) {
		super();
		this.email = email;
		this.title = title;
		this.description = description;
		this.link = link;
		this.targetDate = targetDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

    
}