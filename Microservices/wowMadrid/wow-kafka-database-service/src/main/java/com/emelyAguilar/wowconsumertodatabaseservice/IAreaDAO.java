package com.emelyAguilar.wowconsumertodatabaseservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAreaDAO extends JpaRepository<Area, Long> {
	
	Optional<Area> findByStreetAddressAndPostalCode(String streetAddress, String postalCode);
}
