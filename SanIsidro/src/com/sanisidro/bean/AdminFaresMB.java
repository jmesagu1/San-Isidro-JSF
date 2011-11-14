package com.sanisidro.bean;

import java.util.List;

import com.sanisidro.to.FareTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class AdminFaresMB {

	private String name;
	private double price;
	private String message;

	private List<FareTO> fares;
	private FareTO fareTmp;
	private long editId;
	
	public long getEditId() {
		return editId;
	}
	public void setEditId(long editId) {
		this.editId = editId;
	}
	public AdminFaresMB() {
		fares = new SanIsidroWrapper().getAllFares();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FareTO> getFares() {
		return fares;
	}
	public void setFares(List<FareTO> fares) {
		this.fares = fares;
	}
	public FareTO getFareTmp() {
		return fareTmp;
	}
	public void setFareTmp(FareTO fareTmp) {
		this.fareTmp = fareTmp;
	}

	public String registerFare()
	{
		FareTO fare = new FareTO();
		fare.setName(name);
		fare.setPrice(price);
		SanIsidroWrapper wrapper = new SanIsidroWrapper();
		wrapper.createFare(fare);
		if (fare.getId() != -1) {
			fares = wrapper.getAllFares();
			setMessage("Tarifa registrada exitosamente");
			return "success";
		} else {
			setMessage("Error registrando tarifa");
			return "failure";
		}
	}
	
	public String setEditable()
	{
		int i = 0;
		for (i = 0; i < fares.size(); i++) {
			if (fares.get(i).getId() == editId) {
				fares.get(i).setEditable(true);
				fareTmp = fares.get(i);
			}
			else {
				fares.get(i).setEditable(false);
			}
		}
		return "";
	}

	public String updateFare() {
		if (!fareTmp.getName().trim().equals("")) {
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			if (wrapper.updateFare(fareTmp))
			{
				fareTmp.setEditable(false);
				message = "Tarifa actualizada exitosamente";
				return "success";
			}
			else
			{
				message = "Error actualizando Tarifa";
				return "failure";
			}
		}
		else {
			message = "Debe ingresar un nombre para la tarifa";
			return "failure";
		}
	}
}