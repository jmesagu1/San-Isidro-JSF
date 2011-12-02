package com.sanisidro.to;

import com.sanisidro.annotation.DTO;
import com.sanisidro.entity.ServiceStatus;

@DTO(entityClass = ServiceStatus.class)
public class ServiceStatusTO {

	private long id;
	private String name;
	private String description;
	private boolean editable;

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
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}