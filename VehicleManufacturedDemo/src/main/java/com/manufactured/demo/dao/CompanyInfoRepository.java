package com.manufactured.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manufactured.demo.entity.CompanyInfo;

@Repository
public interface CompanyInfoRepository extends CrudRepository<CompanyInfo, Integer>{
	
	Optional<CompanyInfo> findByCompanyName(String companyName);
}
