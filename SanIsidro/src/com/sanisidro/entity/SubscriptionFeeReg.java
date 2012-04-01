package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the subscription_fee_reg database table.
 * 
 */
@Entity
@Table(name="subscription_fee_reg")
public class SubscriptionFeeReg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_other_charge")
	private String idOtherCharge;

	@Column(name="fee_number")
	private BigInteger feeNumber;

	//bi-directional one-to-one association to OtherCharge
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_other_charge", insertable = false, updatable = false)
	private OtherCharge charge;

	//bi-directional many-to-one association to Subscription
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_subscription")
	private Subscription subscription;

    public SubscriptionFeeReg() {
    }

	public String getIdOtherCharge() {
		return this.idOtherCharge;
	}

	public void setIdOtherCharge(String idOtherCharge) {
		this.idOtherCharge = idOtherCharge;
	}

	public BigInteger getFeeNumber() {
		return this.feeNumber;
	}

	public void setFeeNumber(BigInteger feeNumber) {
		this.feeNumber = feeNumber;
	}

	public OtherCharge getCharge() {
		return this.charge;
	}

	public void setCharge(OtherCharge charge) {
		this.charge = charge;
	}
	
	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
}