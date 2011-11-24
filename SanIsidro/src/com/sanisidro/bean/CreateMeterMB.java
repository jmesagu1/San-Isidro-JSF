package com.sanisidro.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sanisidro.to.MeterTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class CreateMeterMB {

	private String strDateBought;
	private String serie;
	private double price;
	private double payNumber;
	private String comments;
	private double maxMeters;
	private String message;

	public String getStrDateBought() {
		return strDateBought;
	}
	public void setStrDateBought(String strDateBought) {
		this.strDateBought = strDateBought;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(double payNumber) {
		this.payNumber = payNumber;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public double getMaxMeters() {
		return maxMeters;
	}
	public void setMaxMeters(double maxMeters) {
		this.maxMeters = maxMeters;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String createMeter() {
		String result = "failure";
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dateBought = Calendar.getInstance();
		MeterTO meter = new MeterTO();
		try {
			dateBought.setTimeInMillis(format.parse(strDateBought).getTime());
			meter.setSerie(serie);
			meter.setComments(comments);
			meter.setDateBought(dateBought);
			meter.setPrice(price);
			meter.setMaxMeters(maxMeters);
			meter.setPayNumber(payNumber);
			
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			meter = wrapper.createMeter(meter);
			if (meter.getId() != -1) {
				result = "success";
				message = "El contador se ha registrado exitosamente";
			} else {
				message = "El contador no se ha podido registrar";
			}
		} catch (ParseException e) {
			message = "Ha ocurrido un error registrando el contador";
		}
		return result;
	}
}