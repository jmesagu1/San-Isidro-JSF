package com.sanisidro.to;

import com.sanisidro.annotation.DTO;
import com.sanisidro.entity.User;

@DTO(entityClass = User.class)

public class UserTO {


	private long dni;
	private String name;
	private String surname;
	private boolean deleted;
	private String telephone1;
	private String telephone2;
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
	
}
