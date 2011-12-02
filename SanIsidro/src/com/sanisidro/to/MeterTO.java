package com.sanisidro.to;

import java.util.Calendar;

import com.sanisidro.annotation.DTO;
import com.sanisidro.entity.Fare;
import com.sanisidro.entity.Meter;
import com.sanisidro.entity.Service;

@DTO(entityClass = Meter.class)
public class MeterTO {
	private long id;
	private Calendar dateBought;
	private String serie;
	private boolean deleted;
	private double price;
	private double payNumber;
	private String comments;
	private Fare addMeterFare;
	private Service service;
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