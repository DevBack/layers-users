package com.devback.layers.dto;

import com.devback.layers.entities.User;

public class UserInsertDTO {

	private String name;
	private String email;
	private String password;
	
	public UserInsertDTO() {
		
	}

	public UserInsertDTO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserInsertDTO(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
