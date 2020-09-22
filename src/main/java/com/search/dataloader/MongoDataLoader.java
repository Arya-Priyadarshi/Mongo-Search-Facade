package com.search.dataloader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.search.repo.model.Event;
import com.search.repository.EventRepository;
import com.search.utility.JsonPojoConverterUtil;


/**
 * @author aryansh
 *
 */
@Component
public class MongoDataLoader implements ApplicationRunner {

	
	@Autowired
	private EventRepository eventRepository;
	
	public void run(ApplicationArguments args) {
		
		List<Event> events= JsonPojoConverterUtil.jsonToEvents();
		
		eventRepository.saveAll(events);
	}
}
