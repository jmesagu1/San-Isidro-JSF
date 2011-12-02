package com.sanisidro.to;

import com.sanisidro.annotation.DTO;
import com.sanisidro.entity.ServiceType;

@DTO(entityClass = ServiceType.class)
public class ServiceTypeTO {
	private long id;
	private String detail;
	private boolean hasMeter;
 
	private boolean editable;
	
	public ServiceTypeTO() {
		editable = false;
	}

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}   
	public String getDetail() {
		return this.detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}   
	public boolean getHasMeter() {
		return this.hasMeter;
	}
	public void setHasMeter(boolean hasMeter) {
		this.hasMeter = hasMeter;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}