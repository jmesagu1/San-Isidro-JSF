package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the meter database table.
 * 
 */
@Entity
public class Meter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="delete_date")
	private Date deleteDate;

	@Column(name="id_user_insert")
	private BigInteger idUserInsert;

	@Column(name="id_user_update")
	private BigInteger idUserUpdate;

	@Column(name="initial_fee")
	private BigInteger initialFee;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="install_date")
	private Date installDate;

	@Column(name="meter_price")
	private double meterPrice;

	private byte paid;

    @Lob()
	@Column(name="serie_number")
	private String serieNumber;

	@Column(name="total_fees")
	private BigInteger totalFees;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to MeterFeeReg
	@OneToMany(mappedBy="meter")
	private List<MeterFeeReg> meterFeeRegs;

	//bi-directional one-to-one association to SubsMeter
	@OneToOne(mappedBy="meter", fetch=FetchType.LAZY)
	private SubsMeter subsMeter;

	//bi-directional many-to-one association to UsageMeterReg
	@OneToMany(mappedBy="meter")
	private List<UsageMeterReg> usageMeterRegs;

    public Meter() {
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

	public BigInteger getIdUserInsert() {
		return this.idUserInsert;
	}

	public void setIdUserInsert(BigInteger idUserInsert) {
		this.idUserInsert = idUserInsert;
	}

	public BigInteger getIdUserUpdate() {
		return this.idUserUpdate;
	}

	public void setIdUserUpdate(BigInteger idUserUpdate) {
		this.idUserUpdate = idUserUpdate;
	}

	public BigInteger getInitialFee() {
		return this.initialFee;
	}

	public void setInitialFee(BigInteger initialFee) {
		this.initialFee = initialFee;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getInstallDate() {
		return this.installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public double getMeterPrice() {
		return this.meterPrice;
	}

	public void setMeterPrice(double meterPrice) {
		this.meterPrice = meterPrice;
	}

	public byte getPaid() {
		return this.paid;
	}

	public void setPaid(byte paid) {
		this.paid = paid;
	}

	public String getSerieNumber() {
		return this.serieNumber;
	}

	public void setSerieNumber(String serieNumber) {
		this.serieNumber = serieNumber;
	}

	public BigInteger getTotalFees() {
		return this.totalFees;
	}

	public void setTotalFees(BigInteger totalFees) {
		this.totalFees = totalFees;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<MeterFeeReg> getMeterFeeRegs() {
		return this.meterFeeRegs;
	}

	public void setMeterFeeRegs(List<MeterFeeReg> meterFeeRegs) {
		this.meterFeeRegs = meterFeeRegs;
	}
	
	public SubsMeter getSubsMeter() {
		return this.subsMeter;
	}

	public void setSubsMeter(SubsMeter subsMeter) {
		this.subsMeter = subsMeter;
	}
	
	public List<UsageMeterReg> getUsageMeterRegs() {
		return this.usageMeterRegs;
	}

	public void setUsageMeterRegs(List<UsageMeterReg> usageMeterRegs) {
		this.usageMeterRegs = usageMeterRegs;
	}
	
}