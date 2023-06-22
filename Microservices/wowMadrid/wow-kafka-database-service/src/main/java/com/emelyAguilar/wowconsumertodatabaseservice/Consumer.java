package com.emelyAguilar.wowconsumertodatabaseservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@KafkaListener(topics = "${kafka.topic}")
	public void consume(String jsonEvents) {
		try {
			Event[] events = objectMapper.readValue(jsonEvents, Event[].class);
			for(Event event : events) {
				eventService.saveEvent(event);
				logger.info("Eventos guardados");
			}
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
