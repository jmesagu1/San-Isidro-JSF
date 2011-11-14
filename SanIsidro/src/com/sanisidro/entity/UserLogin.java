package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_login database table.
 * 
 */
@Entity
@Table(name="user_login")
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private boolean admin;

    @Lob()
	private String mail;

    @Lob()
	private String pass;

    @Id
    @Lob()
	private String username;

    public UserLogin() {
    }

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}