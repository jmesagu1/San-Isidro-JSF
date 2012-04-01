package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subs_status database table.
 * 
 */
@Entity
@Table(name="subs_status")
public class SubsStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="delete_date")
	private Date deleteDate;

    @Lob()
	private String description;

	@Column(name="id_user_insert")
	private BigInteger idUserInsert;

	@Column(name="id_user_update")
	private BigInteger idUserUpdate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	@Column(name="is_chargeable")
	private byte isChargeable;

    @Lob()
	private String name;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="status")
	private List<Subscription> subscriptions;

    public SubsStatus() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public byte getIsChargeable() {
		return this.isChargeable;
	}

	public void setIsChargeable(byte isChargeable) {
		this.isChargeable = isChargeable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
}