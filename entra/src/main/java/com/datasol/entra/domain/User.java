package com.datasol.entra.domain;

import java.io.Serializable;

public class User implements Serializable{


	private static final long serialVersionUID = 7168990382927442812L;
	
	private Integer userId;
	private String firstName;
	
	public User() {}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
