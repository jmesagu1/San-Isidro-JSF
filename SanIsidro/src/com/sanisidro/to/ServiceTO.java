package com.sanisidro.to;

import java.util.Calendar;

import com.sanisidro.annotation.ModelField;
import com.sanisidro.entity.Fare;
import com.sanisidro.entity.ServiceStatus;
import com.sanisidro.entity.ServiceType;
import com.sanisidro.entity.User;
import com.sanisidro.entity.Zone;

public class ServiceTO {

	private long id;
	private boolean deleted;
	@ModelField(entityClass = Zone.class)
	private ZoneTO zone;
	private Calendar startDate;
	private double priceSuscription;
	private String farmName;
	private long payNumber;
	@ModelField(entityClass = Fare.class)
	private FareTO fare;
	@ModelField(entityClass = User.class)
	private UserTO user;
	@ModelField(entityClass = ServiceStatus.class)
	private ServiceStatusTO status;
	@ModelField(entityClass = ServiceType.class)
	private ServiceTypeTO type;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}   

	public Calendar getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}   
	public double getPriceSuscription() {
		return this.priceSuscription;
	}

	public void setPriceSuscription(double priceSuscription) {
		this.priceSuscription = priceSuscription;
	}   
	public String getFarmName() {
		return this.farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}   
	public long getPayNumber() {
		return this.payNumber;
	}

	public void setPayNumber(long payNumber) {
		this.payNumber = payNumber;
	}
	public ZoneTO getZone() {
		return zone;
	}
	public void setZone(ZoneTO zone) {
		this.zone = zone;
	}
	public FareTO getFare() {
		return fare;
	}
	public void setFare(FareTO fare) {
		this.fare = fare;
	}
	public UserTO getUser() {
		return user;
	}
	public void setUser(UserTO user) {
		this.user = user;
	}
	public ServiceStatusTO getStatus() {
		return status;
	}
	public void setStatus(ServiceStatusTO status) {
		this.status = status;
	}
	public ServiceTypeTO getType() {
		return type;
	}
	public void setType(ServiceTypeTO type) {
		this.type = type;
	}
}