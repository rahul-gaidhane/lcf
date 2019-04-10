package com.example.demo.domain;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commons.CreateEntityResponse;
import com.example.demo.commons.UpdateEntityResponse;
import com.example.demo.errors.BadRequestAlertException;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityRepository activityRepository; 
	
	@Override
	public CreateEntityResponse<UUID> create(ActivityRequest request) {
		LOGGER.info("In service to create activity");
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
		CreateEntityResponse<UUID> response = new CreateEntityResponse<UUID>();
		response.setId(savedActivity.getId());
		response.setMessage("Activity Created");
		
		return response;
	}

	@Override
	public Activity find(String title) {
		Optional<Activity> opActivity = activityRepository.findByTitle(title);
		if(!opActivity.isPresent()) {
			LOGGER.error("activity not found");
		}
		return opActivity.get();
	}

	@Override
	public UpdateEntityResponse<UUID> update(ActivityRequest request, UUID activityId) {
		Optional<Activity> opActivity = activityRepository.findById(activityId);
		if(opActivity.isPresent()) {
			throw new BadRequestAlertException("activity not found", "activity", "dupActivity");
		}
		Activity activity = opActivity.get();
		activity.setAge(request.getAge());
		activity.setClassLevel(request.getClassLevel());
		activity.setConcept(request.getConcept());
		activity.setDemoLink(request.getDemoLink());
		activity.setDescription(request.getDescription());
		activity.setMaterialRequired(request.getMaterialRequired());
		activity.setSubject(request.getSubject());
		activity.setTitle(request.getTitle());
		activity.setTools(request.getTools());
		
		Activity savedActivity = activityRepository.saveAndFlush(activity);
		
		UpdateEntityResponse<UUID> response = new UpdateEntityResponse<>();
		response.setId(activityId);
		response.setMessage("activity updated");
		
		return response;
	}

	@Override
	public Activity find(UUID activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID activityId) {
		// TODO Auto-generated method stub
		
	}

}
