package com.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.dataloader.Filter;
import com.search.repo.model.Event;
import com.search.repository.DynamicEventRepository;
import com.search.utility.JsonPojoConverterUtil;

/**
 * @author aryansh
 *
 */

@RestController
public class SearchController {

	@Autowired
	private DynamicEventRepository dynamicEventRepository;

	@GetMapping("/events/search")
	public List<Event> getResult(@RequestParam(required = false, value = "filter1") String filterStr1,
			@RequestParam(required = false, value = "filter2") String filterStr2) {
		
		Map<String, String> filters = new HashMap<String, String>();

		if (filterStr1 != null) {
			Filter filter1 = JsonPojoConverterUtil.jsonToFilter(filterStr1);
			filters.put(filter1.getAttribute(), filter1.getValue());
		}

		if (filterStr2 != null) {
			Filter filter2 = JsonPojoConverterUtil.jsonToFilter(filterStr2);
			filters.put(filter2.getAttribute(), filter2.getValue());
		}

		List<Event> list = dynamicEventRepository.getEvents(filters);
		return list;
	}
}
