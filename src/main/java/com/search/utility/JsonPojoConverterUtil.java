package com.search.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.search.dataloader.Filter;
import com.search.model.EventsList;
import com.search.repo.model.Event;

/**
 * @author aryansh
 *
 */
public class JsonPojoConverterUtil {

	public static List<Event> jsonToEvents()

	{
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:eventsData.json");
			System.out.println(file.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();

		EventsList list = null;
		try {
			list = mapper.readValue(file, EventsList.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list.getEvents();

	}

	public static Filter jsonToFilter(String filterStr) {
		ObjectMapper mapper = new ObjectMapper();
		Filter filter = null;
		try {
			filter = mapper.readValue(filterStr, Filter.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filter;
	}

}
