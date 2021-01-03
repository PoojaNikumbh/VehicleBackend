package com.manufactured.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manufactured.demo.entity.VehicleRole;

@Repository
public interface VehicleRoleRepository extends CrudRepository<VehicleRole, Integer>{

}
