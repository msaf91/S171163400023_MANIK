package com.niit.cars.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Blog")
@Component
public class Blog {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String blog_title;
	
	public String getTitle() {
		return blog_title;
	}

	public void setTitle(String blog_title) {
		this.blog_title = blog_title;
	}

	@Column
	private String user_id;
	
	
	
	@Column
	private char status;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getUserid() {
		return user_id;
	}

	public void setUserid(String userid) {
		this.user_id = userid;
	}

	
	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

		
	

}
