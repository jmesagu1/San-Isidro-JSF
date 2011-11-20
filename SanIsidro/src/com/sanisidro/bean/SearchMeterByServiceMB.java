package com.sanisidro.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.model.SelectItem;

import com.sanisidro.to.MeterTO;
import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.to.ZoneTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class SearchMeterByServiceMB {

	private String farmName;
	private String strPriceSuscription;
	private String strPayNumber;
	private String strDateFrom;
	private String strDateTo;
	private long zoneId;
	private long serviceTypeId;
	private List<MeterTO> meters;
	private List<SelectItem> serviceTypes;
	private List<SelectItem> zones;
	private boolean renderTable;
	
	public SearchMeterByServiceMB() {
		farmName = "";
		strPriceSuscription = "";
		strPayNumber = "";
		strDateFrom = "";
		strDateTo = "";
		
		SanIsidroWrapper wrapper = new SanIsidroWrapper();
		List<ZoneTO> zoneList = wrapper.getAllZones();
		List<ServiceTypeTO> typeList = wrapper.getAllServiceTypes();
		zones = new ArrayList<SelectItem>();
		serviceTypes = new ArrayList<SelectItem>();
		for (ZoneTO zone : zoneList) {
			zones.add(new SelectItem(zone.getId(), zone.getName()));
		}
		for (ServiceTypeTO serviceType : typeList) {
			serviceTypes.add(new SelectItem(serviceType.getId(), serviceType.getDetail()));
		}
	}

	public List<SelectItem> getServiceTypes() {
		return serviceTypes;
	}
	public void setServiceTypes(List<SelectItem> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}
	public List<SelectItem> getZones() {
		return zones;
	}
	public void setZones(List<SelectItem> zones) {
		this.zones = zones;
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
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public String getStrPriceSuscription() {
		return strPriceSuscription;
	}
	public void setStrPriceSuscription(String strPriceSuscription) {
		this.strPriceSuscription = strPriceSuscription;
	}
	public String getStrPayNumber() {
		return strPayNumber;
	}
	public void setStrPayNumber(String strPayNumber) {
		this.strPayNumber = strPayNumber;
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
	public long getZoneId() {
		return zoneId;
	}
	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}
	public long getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String searchMeters() {
		String result = "failure";
		try {
			double priceSubscription = -1.0;
			long payNumber = -1;
			Calendar dateFrom = null;
			Calendar dateTo = null;
			if (!strPriceSuscription.trim().equals("")) {
				priceSubscription = Double.parseDouble(strPriceSuscription);
			}
			if (!strPayNumber.trim().equals("")) {
				payNumber = Long.parseLong(strPayNumber);
			}
			if (!strDateFrom.trim().equals("") && !strDateTo.trim().equals("")) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				dateFrom = Calendar.getInstance();
				dateTo = Calendar.getInstance();
				dateFrom.setTimeInMillis(format.parse(strDateFrom).getTime());
				dateTo.setTimeInMillis(format.parse(strDateTo).getTime());
			}
			meters = new SanIsidroWrapper().searchMetersByService(farmName, priceSubscription, 
					payNumber, dateFrom, dateTo, zoneId, serviceTypeId);
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