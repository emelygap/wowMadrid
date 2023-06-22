package com.emelyAguilar.wowconsumertodatabaseservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EventService {
	
	@Autowired
	private IEventDAO eventDAO;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private IAddressDAO addressDAO;
	
	@Autowired
	private ILocationDAO locationDAO;
	
	
	public Iterable<Event> getAllEvents() {
        return eventDAO.findAll();
    }
	
	@Transactional
    public Event saveEvent(Event event) {
		
		//Address to setAddresss
		Address eventAddress = event.getAddress();
        if (eventAddress == null) {
            eventAddress = new Address();
        }
        eventAddress = addressService.buildAddress(eventAddress);
        Address findAddress = addressDAO.findByAreaAndDistrict(eventAddress.getArea(), eventAddress.getDistrict());
    	if (findAddress != null) {
			event.setAddress(findAddress);
		} else {
			Address newAddress = addressDAO.save(eventAddress);
			event.setAddress(newAddress);
		}
    	
    	//Location to setLocation
    	Location eventLocation = event.getLocation();
    	if(eventLocation==null) {
    		eventLocation = new Location();
    	}
    	if(eventLocation.getLatitude()== null) {
			eventLocation.setLatitude("No especificado");
		}
    	if(eventLocation.getLongitude()== null) {
			eventLocation.setLongitude("No especificado");
		}
    	Location findLocation = locationDAO.findByLatitudeAndLongitude(eventLocation.getLatitude(), eventLocation.getLongitude());
    	if(findLocation != null) {
    		event.setLocation(findLocation);
    	}else {
    		event.setLocation(locationDAO.save(eventLocation));
    	}
    	
        return eventDAO.save(event);
    }

    public void deleteEvent(String id) {
        eventDAO.deleteById(id);
    }
}

