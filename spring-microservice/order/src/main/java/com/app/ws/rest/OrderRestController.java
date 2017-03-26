package com.app.ws.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Order;
import com.app.service.OrderService;

/**
 * Rest controller for orders
 * 
 * @author seetha.bellamkonda
 *
 */
@RestController
public class OrderRestController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(OrderRestController.class);
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * Get all customer orders by customerId
	 * 
	 * @param customerId Customer Id to get the orders
	 * @return list of orders of the given <tt>customerId</tt>
	 */
	@RequestMapping(value = "/customerorders/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable(value = "customerId") Long customerId) {
		
		LOGGER.debug("getCustomerOrders with customerId: {}", customerId);
		
		List<Order> orders = orderService.getAllCustomerOrders(customerId);
		return  new ResponseEntity<>(orders, HttpStatus.OK);
	}

}
