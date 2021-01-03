package com.manufactured.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="company_info")
public class CompanyInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Integer companyId;
	
	@Column(name="company_name")
    private String companyName;
	
	@JsonIgnore
	@OneToMany(mappedBy="companyInfo")
    private List<Vehicle> vehicle;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}
