package com.sanisidro.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.model.SelectItem;

import com.sanisidro.to.MeterTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class SearchMeterMB {
	
	private String serie;
	private String strPrice;
	private String strDateFrom;
	private String strDateTo;
	private List<MeterTO> meters;
	private boolean renderTable;	
	
	public SearchMeterMB() {
		serie = "";
		strPrice = "";
		strDateFrom = "";
		strDateTo = "";
	}

	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
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
	public String getStrDateFrom() {
		return strDateFrom;
	}
	public void setStrDateFrom(String strDateFrom) {
		this.strDateFrom = strDateFrom;
	}
	public String getStrDateTo() {
		return strDateTo;
	}
	public void setStrDateTo(String strDateTo) {
		this.strDateTo = strDateTo;
	}
	public String getStrPrice() {
		return strPrice;
	}
	public void setStrPrice(String strPrice) {
		this.strPrice = strPrice;
	}

	public String searchMeters() {
		String result = "failure";
		try {
			double price = -1;
			Calendar dateFrom = null;
			Calendar dateTo = null;
			if (!strPrice.trim().equals("")) {
				price = Double.parseDouble(strPrice);
			}
			if (!strDateFrom.trim().equals("") && !strDateTo.trim().equals("")) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				dateFrom = Calendar.getInstance();
				dateTo = Calendar.getInstance();
				dateFrom.setTimeInMillis(format.parse(strDateFrom).getTime());
				dateTo.setTimeInMillis(format.parse(strDateTo).getTime());
			}
			meters = new SanIsidroWrapper().searchMeters(serie, price, dateFrom, dateTo);
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