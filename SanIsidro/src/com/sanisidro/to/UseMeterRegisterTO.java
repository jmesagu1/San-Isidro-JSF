package com.sanisidro.to;

import java.util.Calendar;

import com.sanisidro.annotation.ModelField;
import com.sanisidro.entity.Meter;

public class UseMeterRegisterTO {

	private long id;
	private double countMeter;
	private Calendar dateRegister;
	@ModelField(entityClass = Meter.class)
	private MeterTO meter;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getCountMeter() {
		return countMeter;
	}
	public void setCountMeter(double countMeter) {
		this.countMeter = countMeter;
	}
	public Calendar getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}
	public MeterTO getMeter() {
		return meter;
	}
	public void setMeter(MeterTO meter) {
		this.meter = meter;
	}
}