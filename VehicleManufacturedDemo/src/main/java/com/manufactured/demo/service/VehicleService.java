package com.manufactured.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manufactured.demo.dao.CompanyInfoRepository;
import com.manufactured.demo.dao.VehicleRepository;
import com.manufactured.demo.dto.VehicleRequestDto;
import com.manufactured.demo.dto.VehicleResponseDto;
import com.manufactured.demo.entity.CompanyInfo;
import com.manufactured.demo.entity.Vehicle;

@Service
public class VehicleService {
	
	@Autowired
	private CompanyInfoRepository companyInfoRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> saveListOfVehicles(List<VehicleRequestDto> vehicleRequestDtoList){
		List<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
		for(VehicleRequestDto vehicle: vehicleRequestDtoList) {
			Optional<CompanyInfo> company = companyInfoRepository.findByCompanyName(vehicle.getCompanyName());
			if(company.isPresent()) {
				for(Vehicle v : vehicle.getVehicle()) {
					v.setCompanyInfo(company.get());
					Vehicle vehicleData = vehicleRepository.save(v);
					vehicleArrayList.add(vehicleData);
				}
			}else {
				CompanyInfo companyInfo = new CompanyInfo();
				companyInfo.setCompanyName(vehicle.getCompanyName());
				CompanyInfo companyInfoData =companyInfoRepository.save(companyInfo);
				for(Vehicle v : vehicle.getVehicle()) {
					v.setCompanyInfo(companyInfoData);
					Vehicle vehicleData = vehicleRepository.save(v);
					vehicleArrayList.add(vehicleData);
				}
			}
		}
		return vehicleArrayList;		
	}
	
	public List<VehicleResponseDto> getVehicleByCategory(){
		List<VehicleResponseDto> vehicleResponseDtoList = new ArrayList<VehicleResponseDto>();
	
		List<Integer> noOfWheels = vehicleRepository.findDistinctNoOfWheels();
		for (Integer wheel : noOfWheels) {
			List<Vehicle> vehicle = vehicleRepository.findByNoOfWheels(wheel);
			VehicleResponseDto vehicleResponseDto = new VehicleResponseDto();
			vehicleResponseDto.setCategory(wheel+"-wheelers");
			vehicleResponseDto.setVehicle(vehicle);
			vehicleResponseDtoList.add(vehicleResponseDto);			
		}
		return vehicleResponseDtoList;
		
	}
	
	public List<Vehicle> getVehicleByOrderByName(){
		return  vehicleRepository.findAllByOrderByNameAsc(); 
	}
	
	public List<Vehicle> getVehicleByOrderByNameAndMaxSpeed(){
		List<Vehicle> vehicleList = (List<Vehicle>) vehicleRepository.findAll(); 
		Comparator<Vehicle> compareByNameAndMaxSpeed = Comparator
                .comparing(Vehicle::getName)
                .thenComparing(Vehicle::getMaxSpeed);
		List<Vehicle> sortedVehicleList = vehicleList.stream()
                .sorted(compareByNameAndMaxSpeed)
                .collect(Collectors.toList());
		return sortedVehicleList;	
	}
	
	public List<Vehicle> getVehicleByDateRange(Date startDate, Date endDate){
		return vehicleRepository.findVehicleByDate(startDate,endDate);
	}
	
	public List<Vehicle> getVehicleByCompanyName(String companyName){
		List<Vehicle> vehicleByCompanyList = vehicleRepository.findByCompanyName(companyName);
		List<Vehicle> vehicleList = (List<Vehicle>) vehicleRepository.findAll();
		if(!vehicleByCompanyList.isEmpty()) {
			Vehicle key = vehicleByCompanyList.get(0);
			Comparator<Vehicle> c = new Comparator<Vehicle>() 
	        { 
	            public int compare(Vehicle v1, Vehicle v2) 
	            { 
	                return v1.getCompanyInfo().getCompanyId().compareTo(v2.getCompanyInfo().getCompanyId()); 
	            } 
	        }; 
			int index = Collections.binarySearch(vehicleList, key , c);
			System.out.println(index);
		}
		return vehicleByCompanyList;
	}
}