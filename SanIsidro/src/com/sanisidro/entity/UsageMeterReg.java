package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usage_meter_reg database table.
 * 
 */
@Entity
@Table(name="usage_meter_reg")
public class UsageMeterReg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private String id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="delete_date")
	private Date deleteDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	@Column(name="meter_register")
	private double meterRegister;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional one-to-one association to UsageCharge
	@OneToOne(mappedBy="usageMeterReg", fetch=FetchType.LAZY)
	private UsageCharge usageCharge;

	//bi-directional many-to-one association to Meter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_meter")
	private Meter meter;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_insert")
	private User userInsert;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_update")
	private User userUpdate;

    public UsageMeterReg() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public double getMeterRegister() {
		return this.meterRegister;
	}

	public void setMeterRegister(double meterRegister) {
		this.meterRegister = meterRegister;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public UsageCharge getUsageCharge() {
		return this.usageCharge;
	}

	public void setUsageCharge(UsageCharge usageCharge) {
		this.usageCharge = usageCharge;
	}
	
	public Meter getMeter() {
		return this.meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}
	
	public User getUserInsert() {
		return this.userInsert;
	}

	public void setUserInsert(User userInsert) {
		this.userInsert = userInsert;
	}
	
	public User getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(User userUpdate) {
		this.userUpdate = userUpdate;
	}
	
}