package com.sanisidro.entity;

import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MeterCharge
 *
 */
@Entity
@Table(name="charge_meter_register")
public class MeterCharge
{	   
	@Id
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_meter")
	private Meter meter;
	@Column(name = "total_charge")
	private double totalCharge;
	@Column(name = "number_paid")
	private long numPaid;
	@Column(name = "date_charge")
	@Temporal(value=TemporalType.DATE)
	private Calendar dateCharge;
	private boolean status;
 
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public Meter getMeter() {
		return this.meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}   
	public double getTotalCharge() {
		return this.totalCharge;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}   
	public long getNumPaid() {
		return this.numPaid;
	}

	public void setNumPaid(long numPaid) {
		this.numPaid = numPaid;
	}   
	public Calendar getDateCharge() {
		return this.dateCharge;
	}

	public void setDateCharge(Calendar dateCharge) {
		this.dateCharge = dateCharge;
	}   
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}