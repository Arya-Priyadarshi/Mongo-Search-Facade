package com.search.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.search.repo.model.Event;

/**
 * @author aryansh
 *
 */
public interface EventRepository extends MongoRepository<Event, String>{
	
	List<Event> findByType(String type);

}
