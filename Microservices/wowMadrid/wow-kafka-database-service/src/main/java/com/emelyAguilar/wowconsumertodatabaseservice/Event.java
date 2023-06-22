package com.emelyAguilar.wowconsumertodatabaseservice;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name= "events")
public class Event implements Serializable{
	private static final long serialVersionUID = -2723698518651206933L;
	@Id
	private String id;
	private String title;
	private String description;
	private String type;
	private Boolean free;
	private String price;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
	@Column(name="date_start")
	private LocalDateTime dateStart;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
	@Column(name="date_end")
	private LocalDateTime dateEnd;
	private LocalTime time;
	
	@Column(name="location_name")
	private String eventLocationName;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="address")
	private Address address;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="location")
	private Location location;
	
}
