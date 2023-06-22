package com.emelyAguilar.wowinjector;

import java.util.List;

public interface ICulturalEventService {
	public List<Event> consultEvents();
	
	public void insertEvents(List<Event> eventsList);
	
	public void start();

}
