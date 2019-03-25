package com.example.demo.domain;

import lombok.Data;

@Data
public class ActivityRequest {
	private String title;
	
	private String subject;
	
	private String concept;
	
	private String classLevel;
	
	private Integer age;
	
	private String description;
	
	private String tools;
	
	private String materialRequired;
	
	private String demoLink;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public String getMaterialRequired() {
		return materialRequired;
	}

	public void setMaterialRequired(String materialRequired) {
		this.materialRequired = materialRequired;
	}

	public String getDemoLink() {
		return demoLink;
	}

	public void setDemoLink(String demoLink) {
		this.demoLink = demoLink;
	}
}
