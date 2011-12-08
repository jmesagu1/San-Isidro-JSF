package com.sanisidro.to;

public class FareTO {

	private long id;
	private double price;
	private String name;

	private boolean editable;

	public FareTO() {
		editable = false;
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
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}