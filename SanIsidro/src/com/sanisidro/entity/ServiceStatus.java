package com.sanisidro.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.sanisidro.annotation.Model;
import com.sanisidro.to.ServiceStatusTO;

/**
 * Entity implementation class for Entity: ServiceStatus
 *
 */
@Entity
@Table(name="service_status")
@Model(dtoClass = ServiceStatusTO.class)
public class ServiceStatus implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;

	public ServiceStatus() {
		super();
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
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
