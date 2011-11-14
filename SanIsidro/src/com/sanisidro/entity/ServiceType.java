package com.sanisidro.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ServiceType
 *
 */
@Entity
@Table(name="Service_Type")

public class ServiceType implements Serializable {

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String detail;
	@Column(name = "Has_Meter")
	private boolean hasMeter;
 
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
}