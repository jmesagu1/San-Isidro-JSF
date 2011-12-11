package com.sanisidro.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UseMeterRegister
 *
 */
@Entity
@Table(name="use_meter_register")
public class UseMeterRegister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	@Column(name = "Count_Meter")
	private double countMeter;
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Register")
	private Calendar dateRegister;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id_Meter")
	private Meter meter;
  
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public double getCountMeter() {
		return this.countMeter;
	}

	public void setCountMeter(double countMeter) {
		this.countMeter = countMeter;
	}   
	public Calendar getDateRegister() {
		return this.dateRegister;
	}

	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}
}