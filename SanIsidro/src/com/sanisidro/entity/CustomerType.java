package com.sanisidro.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer_type database table.
 * 
 */
@Entity
@Table(name="customer_type")
public class CustomerType implements Serializable {
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

	@Column(name="max_meters")
	private double maxMeters;

    @Lob()
	private String name;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="type", cascade={CascadeType.MERGE})
	private List<Customer> customers;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_insert")
	private User userInsert;

	//uni-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user_update")
	private User userUpdate;

	//bi-directional many-to-many association to UsageFare
    @ManyToMany
	@JoinTable(
		name="customer_type_usage_fare"
		, joinColumns={
			@JoinColumn(name="id_customer_type")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_usage_fare")
			}
		)
	private List<UsageFare> usageFares;

    public CustomerType() {
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

	public double getMaxMeters() {
		return this.maxMeters;
	}

	public void setMaxMeters(double maxMeters) {
		this.maxMeters = maxMeters;
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

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
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
	
	public List<UsageFare> getUsageFares() {
		return this.usageFares;
	}

	public void setUsageFares(List<UsageFare> usageFares) {
		this.usageFares = usageFares;
	}
	
}