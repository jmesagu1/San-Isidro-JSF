package com.sanisidro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Fare
 *
 */
@Entity
@Table (name = "fare")
public class Fare 
{	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double price;
	@Column(name="Fare_Name")
	private String name;
  
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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}