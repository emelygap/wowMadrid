package com.emelyAguilar.wowinjector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public ObjectMapper getObjectMapper() {
    	return new ObjectMapper().registerModule(new JavaTimeModule());
    }
	
}
