package com.app.test.ws;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.dto.Customer;
import com.app.service.CustomerService;
import com.app.util.CustomerObjectFactory;
import com.app.ws.rest.CustomerRestController;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(MockitoJUnitRunner.class)
public class TestCustomerRestController {
	
	private MockMvc mockMvc;
	
	@Mock
	private CustomerService customerService;
	
	@InjectMocks
	private CustomerRestController customerRestController;
	
	private CustomerObjectFactory factory;
	
	@Before
	public void setUp() {
		factory = new CustomerObjectFactory();
		mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();
	}

	@Test
	public void testCreate() throws Exception {
		Customer customer = factory.createNewCustomer();
		Customer savedCustomer = factory.createSavedCustomer();
		when(customerService.saveOrUpdate(customer)).thenReturn(savedCustomer);
		
		mockMvc.perform(post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customer)))
		.andExpect(status().isOk())
		.andExpect(content().json(asJsonString(savedCustomer)));
	}
	
	private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
