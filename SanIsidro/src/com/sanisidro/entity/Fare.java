package com.sanisidro.entity;

import java.lang.String;
import javax.persistence.*;

import com.sanisidro.annotation.Model;
import com.sanisidro.to.FareTO;

/**
 * Entity implementation class for Entity: Fare
 *
 */
@Entity
@Table (name = "fare")
@Model(dtoClass = FareTO.class)
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