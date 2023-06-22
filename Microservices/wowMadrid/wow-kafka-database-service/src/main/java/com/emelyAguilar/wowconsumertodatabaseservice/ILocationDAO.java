package com.emelyAguilar.wowconsumertodatabaseservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationDAO extends JpaRepository<Location, Integer> {
	
	Location findByLatitudeAndLongitude(String latitude, String longitude);
}
