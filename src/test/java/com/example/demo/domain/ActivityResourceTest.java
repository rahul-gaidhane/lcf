package com.example.demo.domain;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.commons.CreateEntityResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ActivityController.class)
public class ActivityResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ActivityServiceImpl activityService;
	
	@Test
	public void Should_CreateActivity_When_ValidDataIsSent() throws Exception {
		ActivityRequest request = new ActivityRequest();
		request.setAge(5);
		request.setClassLevel(4);
		request.setConcept("counting");
		request.setDemoLink("some link");
		request.setDescription("some description");
		request.setMaterialRequired("no material required");
		request.setSubject("maths");
		request.setTitle("no title");
		request.setTools("no tools required");
		
		CreateEntityResponse<UUID> response = new CreateEntityResponse<>();
		response.setId(UUID.randomUUID());
		response.setMessage("activity created");
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		
        when(activityService.create(Mockito.any())).thenReturn(response);
		
		mockMvc.perform(post("/lcf/activity")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsBytes(request)))
				.andExpect(status().isCreated());
	}
}
