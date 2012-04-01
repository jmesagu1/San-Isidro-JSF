package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="delete_date")
	private Date deleteDate;

	@Column(name="id_user_insert")
	private BigInteger idUserInsert;

	@Column(name="id_user_update")
	private BigInteger idUserUpdate;

	@Column(name="initial_fee")
	private double initialFee;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private byte paid;

    @Lob()
	private String place;

	@Column(name="subscription_price")
	private double subscriptionPrice;

	@Column(name="total_fees")
	private BigInteger totalFees;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to FixedCharge
	@OneToMany(mappedBy="subscription", cascade={CascadeType.MERGE})
	private List<FixedCharge> fixedCharges;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="subscription")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to OtherCharge
	@OneToMany(mappedBy="subscription")
	private List<OtherCharge> otherCharges;

	//bi-directional many-to-one association to SubsMeter
	@OneToMany(mappedBy="subscription")
	private List<SubsMeter> subsMeters;

	//bi-directional many-to-one association to Zone
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_zone")
	private Zone zone;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_customer")
	private Customer customer;

	//bi-directional many-to-one association to UsageFare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usage_fare")
	private UsageFare usageFare;

	//bi-directional many-to-one association to GeneralFare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_add_meter_fare")
	private GeneralFare addMeterFare;

	//bi-directional many-to-one association to GeneralFare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fixed_meter_fare")
	private GeneralFare fixedMeterFare;

	//bi-directional many-to-one association to SubsStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_status")
	private SubsStatus status;

	//bi-directional many-to-one association to SubscriptionFeeReg
	@OneToMany(mappedBy="subscription")
	private List<SubscriptionFeeReg> subscriptionFeeRegs;

    public Subscription() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public double getInitialFee() {
		return this.initialFee;
	}

	public void setInitialFee(double initialFee) {
		this.initialFee = initialFee;
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

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public double getSubscriptionPrice() {
		return this.subscriptionPrice;
	}

	public void setSubscriptionPrice(double subscriptionPrice) {
		this.subscriptionPrice = subscriptionPrice;
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

	public List<FixedCharge> getFixedCharges() {
		return this.fixedCharges;
	}

	public void setFixedCharges(List<FixedCharge> fixedCharges) {
		this.fixedCharges = fixedCharges;
	}
	
	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	public List<OtherCharge> getOtherCharges() {
		return this.otherCharges;
	}

	public void setOtherCharges(List<OtherCharge> otherCharges) {
		this.otherCharges = otherCharges;
	}
	
	public List<SubsMeter> getSubsMeters() {
		return this.subsMeters;
	}

	public void setSubsMeters(List<SubsMeter> subsMeters) {
		this.subsMeters = subsMeters;
	}
	
	public Zone getZone() {
		return this.zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public UsageFare getUsageFare() {
		return this.usageFare;
	}

	public void setUsageFare(UsageFare usageFare) {
		this.usageFare = usageFare;
	}
	
	public GeneralFare getAddMeterFare() {
		return this.addMeterFare;
	}

	public void setAddMeterFare(GeneralFare addMeterFare) {
		this.addMeterFare = addMeterFare;
	}
	
	public GeneralFare getFixedMeterFare() {
		return this.fixedMeterFare;
	}

	public void setFixedMeterFare(GeneralFare fixedMeterFare) {
		this.fixedMeterFare = fixedMeterFare;
	}
	
	public SubsStatus getStatus() {
		return this.status;
	}

	public void setStatus(SubsStatus status) {
		this.status = status;
	}
	
	public List<SubscriptionFeeReg> getSubscriptionFeeRegs() {
		return this.subscriptionFeeRegs;
	}

	public void setSubscriptionFeeRegs(List<SubscriptionFeeReg> subscriptionFeeRegs) {
		this.subscriptionFeeRegs = subscriptionFeeRegs;
	}
	
}