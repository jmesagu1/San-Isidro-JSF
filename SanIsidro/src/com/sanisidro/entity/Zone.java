package com.sanisidro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sanisidro.annotation.Model;
import com.sanisidro.to.ZoneTO;

/**
 * The persistent class for the zone database table.
 * 
 */
@Entity
@Table(name = "zone")
@Model(dtoClass = ZoneTO.class)
public class Zone
{
	@Id	
	private long id;

    @Column(name="zone_Name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String zoneName) {
		this.name = zoneName;
	}
}