package com.sanisidro.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Service
 *
 */
@Entity
@Table(name = "service")
public class Service implements Serializable {
	   
	@Id
	private long id;
	private boolean deleted;	
	@JoinColumn(name = "Id_Zone")
	@ManyToOne(cascade = CascadeType.ALL)
	private Zone zone;
	@Temporal(value = TemporalType.DATE)
	@Column(name = "Start_Date")
	private Calendar startDate;
	@Column (name = "Price_Suscription")
	private double priceSuscription;
	@Column(name = "Farm_Name")
	private String farmName;
	@Column(name = "Pay_Number")
	private long payNumber;	
	@JoinColumn(name = "id_fare")	
	@ManyToOne(cascade = CascadeType.ALL)
	private Fare fare;	
	@JoinColumn(name = "id_user")
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@JoinColumn(name = "Id_Status")
	@ManyToOne(cascade = CascadeType.ALL)
	private ServiceStatus status;	
	@JoinColumn(name = "Id_Service_Type")
	@ManyToOne(cascade = CascadeType.ALL)
	private ServiceType type;
	private static final long serialVersionUID = 1L;

	public Service() {
		super();
	}   
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
	public Zone getZone() {
		return this.zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
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
	public ServiceStatus getStatus() {
		return status;
	}
	public void setStatus(ServiceStatus status) {
		this.status = status;
	}
	public ServiceType getType() {
		return type;
	}
	public void setType(ServiceType type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
   
}
