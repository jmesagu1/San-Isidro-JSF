package com.sanisidro.entity;

import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MeterPay
 *
 */
@Entity
@Table(name="meter_pay_register")

public class MeterPay {
	   
	@Id
	private long id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_charge")
	private MeterCharge charge;
	@Column(name = "date_paid")
	@Temporal(value = TemporalType.DATE)
	private Calendar datePaid;
	@Column(name = "total_paid")
	private double totalPaid;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public MeterCharge getCharge() {
		return this.charge;
	}

	public void setCharge(MeterCharge charge) {
		this.charge = charge;
	}   
	public Calendar getDatePaid() {
		return this.datePaid;
	}

	public void setDatePaid(Calendar datePaid) {
		this.datePaid = datePaid;
	}   
	public double getTotalPaid() {
		return this.totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}
   
}
