package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityRequest {
	private String title;
	
	private String subject;
	
	private String concept;
	
	private int classLevel;
	
	private Integer age;
	
	private String description;
	
	private String tools;
	
	private String materialRequired;
	
	private String demoLink;
}
