package com.example.demo.domain;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityRepository activityRepository; 
	
	@Override
	public String create(ActivityRequest request) {
		Activity activity = new Activity();
		activity.setAge(request.getAge());
		activity.setClassLevel(request.getClassLevel());
		activity.setConcept(request.getConcept());
		activity.setDemoLink(request.getDemoLink());
		activity.setDescription(request.getDescription());
		activity.setMaterialRequired(request.getMaterialRequired());
		activity.setSubject(request.getSubject());
		activity.setTitle(request.getTitle());
		activity.setTools(request.getTools());
		activity.setId(null);
		
		Activity savedActivity = activityRepository.saveAndFlush(activity);
		return savedActivity.getId().toString();
	}

	@Override
	public Activity find(String title) {
		Optional<Activity> opActivity = activityRepository.findByTitle(title);
		if(!opActivity.isPresent()) {
			LOGGER.error("activity not found");
		}
		return opActivity.get();
	}

}
