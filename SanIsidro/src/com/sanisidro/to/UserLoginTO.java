package com.sanisidro.to;

import com.sanisidro.annotation.DTO;
import com.sanisidro.entity.UserLogin;

@DTO(entityClass = UserLogin.class)
public class UserLoginTO {
	private boolean admin;   
	private String mail;   
	private String pass;   
	private String username;
	
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
