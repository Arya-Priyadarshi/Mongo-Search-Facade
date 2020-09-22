package com.search.model;

import java.util.List;

import com.search.repo.model.Event;

/**
 * @author aryansh
 *
 */
public class EventsList 
{
private List<Event> events;

public List<Event> getEvents() {
	return events;
}

public void setEvents(List<Event> events) {
	this.events = events;
}

}
