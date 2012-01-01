package com.sanisidro.entity;

import com.sanisidro.entity.Service;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UseChargeRegister
 *
 */
@Entity
@Table(name="use_charge_register")
public class UseChargeRegister implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id_Service")
	private Service service;
	@Temporal(TemporalType.DATE)
	@Column(name = "Charge_Date")
	private Calendar chargeDate;
	@Column(name = "Price")
	private double price;
	@Column(name = "Add_Meters_Price")
	private double addMeterPrice;
	@Column(name = "Pay_State")
	private boolean payStatus;
	@Column(name = "Max_Meters")
	private double maxMeters;
  
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}   
	public Calendar getChargeDate() {
		return this.chargeDate;
	}

	public void setChargeDate(Calendar chargeDate) {
		this.chargeDate = chargeDate;
	}   
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public double getAddMeterPrice() {
		return this.addMeterPrice;
	}

	public void setAddMeterPrice(double addMeterPrice) {
		this.addMeterPrice = addMeterPrice;
	}   
	public boolean getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}   
	public double getMaxMeters() {
		return this.maxMeters;
	}

	public void setMaxMeters(double maxMeters) {
		this.maxMeters = maxMeters;
	}
   
}
