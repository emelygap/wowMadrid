package com.emelyAguilar.wowconsumertodatabaseservice;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface IDistrictDAO extends CrudRepository<District, Integer> {
	
	Optional<District> findByDistrictName(String districtName);
}
