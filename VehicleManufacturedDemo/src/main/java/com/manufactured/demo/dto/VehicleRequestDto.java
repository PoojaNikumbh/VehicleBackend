package com.manufactured.demo.dto;

import java.util.List;

import com.manufactured.demo.entity.Vehicle;

public class VehicleRequestDto {
	
	private String companyName;
	
	private List<Vehicle> vehicle;

	
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
