package com.sanisidro.to;

import com.sanisidro.annotation.ModelField;
import com.sanisidro.entity.UserType;

public class UserTO {

	private long id_user;
	private long dni;
	private String name;
	private String surname;
	private boolean deleted;
	private String telephone1;
	private String telephone2;
	@ModelField(entityClass = UserType.class)
	private UserTypeTO type;
	private boolean editable = true;
   
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
	public UserTypeTO getType() {
		return type;
	}
	public void setType(UserTypeTO type) {
		this.type = type;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	
}
