package com.sanisidro.to;

import java.util.Calendar;

import com.sanisidro.annotation.ModelField;
import com.sanisidro.entity.Service;

public class UseChargeRegisterTO {

	private long id;
	@ModelField(entityClass = Service.class)
	private ServiceTO service;
	private Calendar chargeDate;
	private double price;
	private double addMeterPrice;
	private boolean payStatus;
	private double maxMeters;
  
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public ServiceTO getService() {
		return this.service;
	}

	public void setService(ServiceTO service) {
		this.service = service;
	}   
	public Calendar getChargeDate() {
		return this.chargeDate;
	}

	public void setChargeDate(Calendar chargeDate) {
		this.chargeDate = chargeDate;
	}   
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public double getAddMeterPrice() {
		return this.addMeterPrice;
	}

	public void setAddMeterPrice(double addMeterPrice) {
		this.addMeterPrice = addMeterPrice;
	}   
	public boolean getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}   
	public double getMaxMeters() {
		return this.maxMeters;
	}

	public void setMaxMeters(double maxMeters) {
		this.maxMeters = maxMeters;
	}
}