package com.example.demo.domain;

import java.util.UUID;

import com.example.demo.commons.CreateEntityResponse;
import com.example.demo.commons.UpdateEntityResponse;

public interface ActivityService {
	public CreateEntityResponse<UUID> create(ActivityRequest request);
	
	public Activity find(String title);

	public UpdateEntityResponse<UUID> update(ActivityRequest request, UUID activityId);

	public Activity find(UUID activityId);

	public void delete(UUID activityId);
	
}
