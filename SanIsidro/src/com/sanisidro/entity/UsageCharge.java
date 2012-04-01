package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usage_charge database table.
 * 
 */
@Entity
@Table(name="usage_charge")
public class UsageCharge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usage")
	private String idUsage;

	@Column(name="add_meter_value")
	private double addMeterValue;

	@Column(name="add_meters")
	private double addMeters;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="delete_date")
	private Date deleteDate;

	@Column(name="fixed_charge_value")
	private double fixedChargeValue;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private byte paid;

	@Column(name="total_meters")
	private double totalMeters;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="value_per_meter")
	private double valuePerMeter;

	//bi-directional one-to-one association to UsageMeterReg
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usage", insertable = false, updatable = false)
	
	private UsageMeterReg usageMeterReg;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_insert")
	private User userInsert;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_update")
	private User userUpdate;

	//bi-directional many-to-one association to Invoice
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_invoice")
	private Invoice invoice;

	//bi-directional many-to-one association to UsageChargePayout
	@OneToMany(mappedBy="usageCharge")
	private List<UsageChargePayout> usageChargePayouts;

    public UsageCharge() {
    }

	public String getIdUsage() {
		return this.idUsage;
	}

	public void setIdUsage(String idUsage) {
		this.idUsage = idUsage;
	}

	public double getAddMeterValue() {
		return this.addMeterValue;
	}

	public void setAddMeterValue(double addMeterValue) {
		this.addMeterValue = addMeterValue;
	}

	public double getAddMeters() {
		return this.addMeters;
	}

	public void setAddMeters(double addMeters) {
		this.addMeters = addMeters;
	}

	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public double getFixedChargeValue() {
		return this.fixedChargeValue;
	}

	public void setFixedChargeValue(double fixedChargeValue) {
		this.fixedChargeValue = fixedChargeValue;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public byte getPaid() {
		return this.paid;
	}

	public void setPaid(byte paid) {
		this.paid = paid;
	}

	public double getTotalMeters() {
		return this.totalMeters;
	}

	public void setTotalMeters(double totalMeters) {
		this.totalMeters = totalMeters;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public double getValuePerMeter() {
		return this.valuePerMeter;
	}

	public void setValuePerMeter(double valuePerMeter) {
		this.valuePerMeter = valuePerMeter;
	}

	public UsageMeterReg getUsageMeterReg() {
		return this.usageMeterReg;
	}

	public void setUsageMeterReg(UsageMeterReg usageMeterReg) {
		this.usageMeterReg = usageMeterReg;
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
	
	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public List<UsageChargePayout> getUsageChargePayouts() {
		return this.usageChargePayouts;
	}

	public void setUsageChargePayouts(List<UsageChargePayout> usageChargePayouts) {
		this.usageChargePayouts = usageChargePayouts;
	}
	
}