package com.sprphnx.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Departments")
public class Departments {

	@Id
	@Column(name = "DEPARTMENT_ID")
	long departpentId;
	
	@Column(name = "DEPARTMENT_NAME")
	String departmentName;
	
	@Column(name = "MANAGER_ID")
	long managerId;
	
	@Column(name = "LOCATION_ID")
	long locationId;
	
	public Departments() {
	
	}

	public Departments(long departpentId, String departmentName, long managerId, long locationId) {
		super();
		this.departpentId = departpentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	public long getDepartpentId() {
		return departpentId;
	}

	public void setDepartpentId(long departpentId) {
		this.departpentId = departpentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
}
