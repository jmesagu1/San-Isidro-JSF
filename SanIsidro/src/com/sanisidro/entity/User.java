package com.sanisidro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "customer")
public class User{
	
	@Id	
	private long dni;
	@Column(name="User_Name")
	private String name;
	private String surname;
	private boolean deleted;
	@Column(name="Telephone_1")
	private String telephone1;
	@Column(name="Telephone_2")
	private String telephone2;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Type")
	private UserType type;
   
	public long getDni() {
		return this.dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}   
	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}   
	public String getTelephone1() {
		return this.telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}   
	public String getTelephone2() {
		return this.telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
}