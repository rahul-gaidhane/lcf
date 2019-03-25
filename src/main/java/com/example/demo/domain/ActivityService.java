package com.example.demo.domain;

public interface ActivityService {
	public String create(ActivityRequest request);
	
	public Activity find(String title);
	
}
