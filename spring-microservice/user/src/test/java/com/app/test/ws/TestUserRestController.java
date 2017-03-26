package com.app.test.ws;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.dto.User;
import com.app.service.UserService;
import com.app.util.UserObjectFactory;
import com.app.ws.rest.UserRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class TestUserRestController {
	
	private MockMvc mockMvc;
	private UserObjectFactory factory;
	private ObjectMapper mapper;
	
	@Mock
	private UserService userService;
	
	@Mock
	private BCryptPasswordEncoder encoder;
	
	@InjectMocks
	private UserRestController userRestController;
	
	@Before
	public void setUp() {
		factory = new UserObjectFactory();
		mapper  = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(userRestController).build();
	}
	
	@Test
	public void testCreate() throws Exception {
		User newUser = factory.createNewUser();
		User savedUser = factory.createSavedUser();
		when(userService.saveOrUpdate(newUser)).thenReturn(savedUser);
		mockMvc.perform(post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(newUser)))
		.andExpect(status().isCreated())
		.andExpect(content().json(mapper.writeValueAsString(savedUser)));
	}
	
	@Test
	public void testAuthenticate() throws Exception {
		User savedUser = factory.createSavedUser();
		User newUser = factory.createNewUser();
		when(userService.findByUserName(savedUser.getUserName())).thenReturn(savedUser);
		when(encoder.matches(newUser.getPassword(), savedUser.getPassword())).thenReturn(true);
		mockMvc.perform(post("/authenticate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(newUser)))
		.andExpect(status().isOk())
		.andExpect(content().string("true"));
	}

}
