package com.search.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.search.constant.EventConstant;
import com.search.repo.model.Event;

/**
 * @author aryansh
 *
 */
@Repository
public class DynamicEventRepository 
{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Event> getEvents(Map<String, String> filterMap)
	{
		 Set<String> filterKeys = filterMap.keySet();
		 Query dynamicQuery = new Query();
		 
		if (filterKeys.contains(EventConstant.FIELD_TYPE)) 
		{
		   String typeValue = filterMap.get(EventConstant.FIELD_TYPE);
		   Criteria typeCriteria = Criteria.where(EventConstant.FIELD_TYPE).is(typeValue);
		   dynamicQuery.addCriteria(typeCriteria);
		}
		if (filterKeys.contains(EventConstant.FIELD_USER))
		{
		   String userValue = filterMap.get(EventConstant.FIELD_USER);
		   Criteria userCriteria = Criteria.where(EventConstant.FIELD_USER).is(userValue);
		   dynamicQuery.addCriteria(userCriteria);
		}
		List<Event> result = mongoTemplate.find(dynamicQuery, Event.class, EventConstant.COLLECTION);
		return result;
	}
}
