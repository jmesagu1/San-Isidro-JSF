package com.sanisidro.to;

import com.sanisidro.annotation.DTO;
import com.sanisidro.entity.UserType;

@DTO(entityClass = UserType.class)
public class UserTypeTO {

	private long id;
	private String name;
	
	private boolean editable;
	
	public UserTypeTO() {
		editable = false;
	}
 
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}