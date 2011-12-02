package com.sanisidro.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ServiceStateRegister
 *
 */
@Entity
@Table(name="service_status_register")
public class ServiceStateRegister implements Serializable {

	   
	@Id
	private long id;	
	private long id_service;
	private double price;
	@Temporal(TemporalType.DATE)
	@Column (name = "change_Date")
	private Calendar changeDate;
	private static final long serialVersionUID = 1L;

	public ServiceStateRegister() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public Calendar getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Calendar changeDate) {
		this.changeDate = changeDate;
	}
	public long getId_service() {
		return id_service;
	}
	public void setId_service(long id_service) {
		this.id_service = id_service;
	}
   
}
