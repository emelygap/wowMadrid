package com.emelyAguilar.wowconsumertodatabaseservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="locations")
public class Location implements Serializable{
	
	private static final long serialVersionUID = 8863212089355653939L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String latitude;
	private String longitude;
	
	@OneToMany(mappedBy = "location", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Event> eventList;
	
	public void addEvent(Event event) {
		if (eventList==null) {
			eventList= new ArrayList<>();
		}
		eventList.add(event);
		event.setLocation(this);
	}
}
