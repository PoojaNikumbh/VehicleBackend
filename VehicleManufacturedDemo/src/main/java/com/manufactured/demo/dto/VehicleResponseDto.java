package com.manufactured.demo.dto;

import java.util.List;

import com.manufactured.demo.entity.Vehicle;

public class VehicleResponseDto {

	private String category;
	
	private List<Vehicle> vehicle;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}