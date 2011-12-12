package com.sanisidro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ServiceType
 *
 */
@Entity
@Table(name="service_type")
public class ServiceType implements Serializable {

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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