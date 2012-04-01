package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	//bi-directional many-to-one association to FixedCharge
	@OneToMany(mappedBy="invoice")
	private List<FixedCharge> fixedCharges;

	//bi-directional many-to-one association to Subscription
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_subscription")
	private Subscription subscription;

	//bi-directional many-to-one association to OtherCharge
	@OneToMany(mappedBy="invoice")
	private List<OtherCharge> otherCharges;

	//bi-directional many-to-one association to UsageCharge
	@OneToMany(mappedBy="invoice")
	private List<UsageCharge> usageCharges;

    public Invoice() {
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

	public List<FixedCharge> getFixedCharges() {
		return this.fixedCharges;
	}

	public void setFixedCharges(List<FixedCharge> fixedCharges) {
		this.fixedCharges = fixedCharges;
	}
	
	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public List<OtherCharge> getOtherCharges() {
		return this.otherCharges;
	}

	public void setOtherCharges(List<OtherCharge> otherCharges) {
		this.otherCharges = otherCharges;
	}
	
	public List<UsageCharge> getUsageCharges() {
		return this.usageCharges;
	}

	public void setUsageCharges(List<UsageCharge> usageCharges) {
		this.usageCharges = usageCharges;
	}
	
}