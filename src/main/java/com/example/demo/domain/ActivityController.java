package com.example.demo.domain;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commons.CreateEntityResponse;
import com.example.demo.commons.UpdateEntityResponse;
import com.example.demo.rest.util.HeaderUtil;

@RestController
@RequestMapping("/lcf")
public class ActivityController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);
	private static final String ENTITY_NAME = "Activity";
	
	@Autowired
	private ActivityService service;
	
	@PostMapping("/activity")
	public ResponseEntity<CreateEntityResponse<UUID>> create(@RequestBody ActivityRequest request) throws URISyntaxException {
		CreateEntityResponse<UUID> response = service.create(request);
		return ResponseEntity.created(new URI("/lcf/activity/" + response.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, response.getId().toString()))
				.body(response);
	}
	
	@PutMapping("/activity/{activityId}")
	public ResponseEntity<UpdateEntityResponse<UUID>> update(@PathVariable("activityId") UUID activityId, 
			@RequestBody ActivityRequest request) {
		UpdateEntityResponse<UUID> response = service.update(request, activityId);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/activity/{activityId}")
	public ResponseEntity<Activity> find(@PathVariable("activityId") UUID activityId) {
		Activity response = service.find(activityId);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/activity/{activityId}")
	public ResponseEntity<Void> delete(@PathVariable("activityId") UUID activityId) {
		service.delete(activityId);
		return ResponseEntity.ok().build();
	}

}
