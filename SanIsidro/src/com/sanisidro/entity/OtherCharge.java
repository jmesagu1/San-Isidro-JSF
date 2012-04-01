package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the other_charge database table.
 * 
 */
@Entity
@Table(name="other_charge")
public class OtherCharge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

    @Lob()
	private String concept;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="delete_date")
	private Date deleteDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private byte paid;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="value_charge")
	private double valueCharge;

	//bi-directional one-to-one association to MeterFeeReg
	@OneToOne(mappedBy="charge", fetch=FetchType.LAZY)
	private MeterFeeReg meterFeeReg;

	//bi-directional many-to-one association to Subscription
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_subscription")
	private Subscription subscription;

	//bi-directional many-to-one association to Invoice
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_invoice")
	private Invoice invoice;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_insert")
	private User userInsert;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_update")
	private User userUpdate;

	//bi-directional many-to-one association to OtherChargePayout
	@OneToMany(mappedBy="charge")
	private List<OtherChargePayout> payouts;

	//bi-directional one-to-one association to SubscriptionFeeReg
	@OneToOne(mappedBy="charge", fetch=FetchType.LAZY)
	private SubscriptionFeeReg subscriptionFeeReg;

    public OtherCharge() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConcept() {
		return this.concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
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

	public byte getPaid() {
		return this.paid;
	}

	public void setPaid(byte paid) {
		this.paid = paid;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public double getValueCharge() {
		return this.valueCharge;
	}

	public void setValueCharge(double valueCharge) {
		this.valueCharge = valueCharge;
	}

	public MeterFeeReg getMeterFeeReg() {
		return this.meterFeeReg;
	}

	public void setMeterFeeReg(MeterFeeReg meterFeeReg) {
		this.meterFeeReg = meterFeeReg;
	}
	
	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
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
	
	public List<OtherChargePayout> getPayouts() {
		return this.payouts;
	}

	public void setPayouts(List<OtherChargePayout> payouts) {
		this.payouts = payouts;
	}
	
	public SubscriptionFeeReg getSubscriptionFeeReg() {
		return this.subscriptionFeeReg;
	}

	public void setSubscriptionFeeReg(SubscriptionFeeReg subscriptionFeeReg) {
		this.subscriptionFeeReg = subscriptionFeeReg;
	}
	
}