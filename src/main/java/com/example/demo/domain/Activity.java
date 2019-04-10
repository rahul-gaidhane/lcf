package com.example.demo.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {
	
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	private UUID id;
	
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
	