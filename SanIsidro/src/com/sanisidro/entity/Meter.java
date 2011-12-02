package com.sanisidro.entity;

import java.lang.String;
import java.util.Calendar;
import javax.persistence.*;

import com.sanisidro.annotation.Model;
import com.sanisidro.to.MeterTO;

/**
 * Entity implementation class for Entity: Meter
 *
 */
@Entity
@Table (name = "meter")
@Model(dtoClass = MeterTO.class)
public class Meter 
{
	@Id
	private long id;
	@Temporal(value=TemporalType.DATE)
	@Column(name="Date_Bought")
	private Calendar dateBought;
	private String serie;
	private boolean deleted;
	private double price;
	@Column(name="Pay_Number")
	private double payNumber;
	private String comments;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fare")	
	private Fare addMeterFare;

	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "id_service")
	private Service service;
	
	@Column(name = "max_meters")
	private double maxMeters;

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}   
	public Calendar getDateBought() {
		return this.dateBought;
	}

	public void setDateBought(Calendar dateBought) {
		this.dateBought = dateBought;
	}   
	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}   
	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}   
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public double getPayNumber() {
		return this.payNumber;
	}

	public void setPayNumber(double payNumber) {
		this.payNumber = payNumber;
	}   
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Fare getAddMeterFare() {
		return addMeterFare;
	}

	public void setAddMeterFare(Fare addMeterFare) {
		this.addMeterFare = addMeterFare;
	}

	public double getMaxMeters() {
		return maxMeters;
	}

	public void setMaxMeters(double maxMeters) {
		this.maxMeters = maxMeters;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
}