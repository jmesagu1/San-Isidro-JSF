package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the general_fare database table.
 * 
 */
@Entity
@Table(name="general_fare")
public class GeneralFare implements Serializable {
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

    @Lob()
	private String name;

	private byte smmlv;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	private double value;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_insert")
	private User userInsert;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_update")
	private User userUpdate;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="addMeterFare")
	private List<Subscription> subscriptionsAddMeters;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="fixedMeterFare")
	private List<Subscription> subscriptionsFixedMeterFares;

    public GeneralFare() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getSmmlv() {
		return this.smmlv;
	}

	public void setSmmlv(byte smmlv) {
		this.smmlv = smmlv;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
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
	
	public List<Subscription> getSubscriptionsAddMeters() {
		return this.subscriptionsAddMeters;
	}

	public void setSubscriptionsAddMeters(List<Subscription> subscriptionsAddMeters) {
		this.subscriptionsAddMeters = subscriptionsAddMeters;
	}
	
	public List<Subscription> getSubscriptionsFixedMeterFares() {
		return this.subscriptionsFixedMeterFares;
	}

	public void setSubscriptionsFixedMeterFares(List<Subscription> subscriptionsFixedMeterFares) {
		this.subscriptionsFixedMeterFares = subscriptionsFixedMeterFares;
	}
	
}