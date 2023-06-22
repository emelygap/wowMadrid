package com.emelyAguilar.wowinjector;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Event {
	
	private String id;
	private String title;
	private String description;
	private String type;
	private Boolean free;
	private String price;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	@JsonAlias({"dtstart"})
	private LocalDateTime dateStart;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	@JsonAlias({"dtend"})
	private LocalDateTime dateEnd;
	
	private LocalTime time;
	@JsonAlias({"event-location"})
	private String eventLocationName;
	private Address address;
	private Location location;
	
	@JsonAlias({"@type"})
	public void setType(String nameType) {
		this.type = nameType.substring(nameType.lastIndexOf("/") + 1);
	}
	
}
