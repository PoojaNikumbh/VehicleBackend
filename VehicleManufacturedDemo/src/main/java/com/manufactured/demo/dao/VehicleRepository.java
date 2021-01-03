package com.manufactured.demo.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manufactured.demo.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer>{
	
	@Query("select distinct noOfWheels from Vehicle")
	List<Integer> findDistinctNoOfWheels();
	
	List<Vehicle> findByNoOfWheels(Integer noOfWheels);
	
	List<Vehicle> findAllByOrderByNameAsc();
	
	@Query("from Vehicle where manufacturedDate between :startDate AND :endDate")
	List<Vehicle> findVehicleByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("select v from Vehicle v where v.companyInfo.companyName=:companyName")
	List<Vehicle> findByCompanyName(String companyName);
}
