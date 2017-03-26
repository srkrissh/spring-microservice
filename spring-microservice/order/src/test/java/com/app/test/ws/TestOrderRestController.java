package com.app.test.ws;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.dto.Order;
import com.app.service.OrderService;
import com.app.util.OrderObjectFactory;
import com.app.ws.rest.OrderRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class TestOrderRestController {
	
	private MockMvc mockMvc;
	private OrderObjectFactory factory;
	
	@Mock
	private OrderService orderService;
	
	@InjectMocks
	private OrderRestController orderRestController;
	
	@Before
	public void setUp() {
		factory  = new OrderObjectFactory();
		mockMvc = MockMvcBuilders.standaloneSetup(orderRestController).build();
	}
	
	@Test
	public void testGetCustomerOrders() throws Exception {
		List<Order> customerOrders = factory.createOrderList();
		Mockito.when(orderService.getAllCustomerOrders(1L)).thenReturn(customerOrders);

		mockMvc.perform(get("/customerorders/{customerId}", 1L))
		.andExpect(status().isOk())
		.andExpect(content().json(new ObjectMapper().writeValueAsString(customerOrders)));
		
	}
	

}
