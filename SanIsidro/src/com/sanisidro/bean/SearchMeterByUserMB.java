package com.sanisidro.bean;

import java.util.List;

import com.sanisidro.to.MeterTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class SearchMeterByUserMB {
	
	private String name;
	private String lastname;
	private String strDni;
	private List<MeterTO> meters;
	private boolean renderTable;
	
	public SearchMeterByUserMB() {
		name = "";
		lastname = "";
		strDni = "";
		renderTable = false;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<MeterTO> getMeters() {
		return meters;
	}
	public void setMeters(List<MeterTO> meters) {
		this.meters = meters;
	}
	public boolean isRenderTable() {
		return renderTable;
	}
	public void setRenderTable(boolean renderTable) {
		this.renderTable = renderTable;
	}
	public String getStrDni() {
		return strDni;
	}
	public void setStrDni(String strDni) {
		this.strDni = strDni;
	}

	public String searchMeters() {
		String result = "failure";
		try {
			long dni = -1;
			if (!strDni.trim().equals("")) {
				dni = Long.parseLong(strDni);
			}
			meters = new SanIsidroWrapper().searchMetersByUser(name, lastname, dni);
			if (meters != null && !meters.isEmpty()) {
				renderTable = true;
				result = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			renderTable = false;
		}
		return result;
	}
}