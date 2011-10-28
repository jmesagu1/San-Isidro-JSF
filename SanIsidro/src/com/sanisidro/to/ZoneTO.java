package com.sanisidro.to;

public class ZoneTO {

	private long id;
	private String name;
	
	private boolean editable;
	
	public ZoneTO() {
		editable = false;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String zoneName) {
		this.name = zoneName;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}