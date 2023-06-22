package com.emelyAguilar.wowconsumertodatabaseservice;

import java.util.*;
import java.util.Optional;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AddressService {
    
    @Autowired
    private IDistrictDAO districtDAO;
    
    @Autowired
    private IAreaDAO areaDAO;
    
    @Transactional
    public Address buildAddress(Address address) {
    	if(address.getArea()==null) {
    		Area areaDf = new Area();
    		areaDf.setStreetAddress("No especificado");
    		areaDf.setPostalCode("No especificado");
    		address.setArea(areaDf);
    	}
    	if(address.getDistrict()==null) {
    		District districtDf = new District();
    		districtDf.setDistrictName("No especificado");
    		address.setDistrict(districtDf);
    	}
    	
    	Optional<Area> optionalArea = areaDAO.findByStreetAddressAndPostalCode(address.getArea().getStreetAddress(), address.getArea().getPostalCode());
		Optional<District> optionalDistrict = districtDAO.findByDistrictName(address.getDistrict().getDistrictName());

		if (optionalDistrict.isPresent()) {
			address.setDistrict(optionalDistrict.get());
		} else {
			District newDistrict = districtDAO.save(address.getDistrict());
			address.setDistrict(newDistrict);
		}
		
		if (optionalArea.isPresent()) {
			address.setArea(optionalArea.get());
		} else {
			Area newArea = areaDAO.save(address.getArea());
			address.setArea(newArea);
		}

        return address;
    }
    
}
