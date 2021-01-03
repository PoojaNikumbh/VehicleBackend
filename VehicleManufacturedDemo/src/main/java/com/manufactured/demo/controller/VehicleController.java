package com.manufactured.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manufactured.demo.dto.ResultModel;
import com.manufactured.demo.dto.VehicleRequestDto;
import com.manufactured.demo.dto.VehicleResponseDto;
import com.manufactured.demo.entity.Vehicle;
import com.manufactured.demo.service.VehicleService;

@RestController
@RequestMapping(value="/vehicleInfo")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/saveListOfVehicles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveListOfVehicles(@RequestBody List<VehicleRequestDto> vehicleRequestDtoList) {
		ResultModel resultModel = new ResultModel();
		try {
			List<Vehicle> response = vehicleService.saveListOfVehicles(vehicleRequestDtoList);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getVehicleByCategory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleByCategory() {
		ResultModel resultModel = new ResultModel();
		try {
			List<VehicleResponseDto> response = vehicleService.getVehicleByCategory();
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVehicleByOrderByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleByOrderByName() {
		ResultModel resultModel = new ResultModel();
		try {
			List<Vehicle> response = vehicleService.getVehicleByOrderByName();
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVehicleByOrderByNameAndMaxSpeed", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleByOrderByNameAndMaxSpeed() {
		ResultModel resultModel = new ResultModel();
		try {
			List<Vehicle> response = vehicleService.getVehicleByOrderByNameAndMaxSpeed();
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVehicleByDateRange/{startDate}/{endDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleByDateRange(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) {
		ResultModel resultModel = new ResultModel();
		try {
			List<Vehicle> response = vehicleService.getVehicleByDateRange(startDate,endDate);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVehicleByCompanyName/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleByCompanyName(@PathVariable("companyName") String companyName) {
		ResultModel resultModel = new ResultModel();
		try {
			List<Vehicle> response = vehicleService.getVehicleByCompanyName(companyName);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
}
