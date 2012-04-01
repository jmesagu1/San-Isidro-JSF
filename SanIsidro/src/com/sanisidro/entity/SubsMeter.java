package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the subs_meter database table.
 * 
 */
@Entity
@Table(name="subs_meter")
public class SubsMeter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_meter")
	private String idMeter;

    @Lob()
	private String comment;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	@Column(name="is_current")
	private byte isCurrent;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to Subscription
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_subscription")
	private Subscription subscription;

	//bi-directional one-to-one association to Meter
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_meter", insertable = false, updatable = false)
	private Meter meter;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_insert")
	private User userInsert;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_update")
	private User userUpdate;

    public SubsMeter() {
    }

	public String getIdMeter() {
		return this.idMeter;
	}

	public void setIdMeter(String idMeter) {
		this.idMeter = idMeter;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public byte getIsCurrent() {
		return this.isCurrent;
	}

	public void setIsCurrent(byte isCurrent) {
		this.isCurrent = isCurrent;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
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