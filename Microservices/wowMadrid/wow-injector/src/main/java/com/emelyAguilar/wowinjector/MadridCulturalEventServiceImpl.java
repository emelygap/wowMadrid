package com.emelyAguilar.wowinjector;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class MadridCulturalEventServiceImpl implements ICulturalEventService {

	@Autowired
	private RestTemplate resttemplate;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<Event> consultEvents() {
		ResponseEntity<MadridResponse> response = resttemplate.getForEntity(
				"https://datos.madrid.es/egob/catalogo/206974-0-agenda-eventos-culturales-100.json",
				MadridResponse.class);
		MadridResponse mr = response.getBody();
		return mr.getEvents();
	}

	@Override
	public void insertEvents(List<Event> eventsList) {
		try {
			String jsonEvent = objectMapper.writeValueAsString(eventsList);
			ProducerRecord<String, String> record = new ProducerRecord<>("culturalEvents", jsonEvent);
			kafkaTemplate.send(record).get();
			log.info("Mensaje enviado a Kafka: ");
		} catch (JsonProcessingException | InterruptedException | ExecutionException e) {
			log.error("Error al enviar mensaje a Kafka: " + e.getMessage());
		}
	}

	@Override
	@Scheduled(fixedRate = 1800000)//30min (12h = 43200000)
	public void start() {
		insertEvents(consultEvents());
	}

}
