package com.emelyAguilar.wowconsumertodatabaseservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressDAO extends JpaRepository<Address, Integer>{
	
	Address findByAreaAndDistrict(Area idArea, District idDistrict);
	//Optional<Address> findByAreaAndDistrict (int areaId, int districtId);
}
