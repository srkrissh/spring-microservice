package com.app.util;

import com.app.dto.Customer;
import com.app.entity.CustomerEntity;

/**
 * Factory to create objects for test data
 * This removes the object creation code from the test methods.
 * 
 * @author Seetharama Krishna
 *
 */
public class CustomerObjectFactory {
	
	/**
	 * Create {@link Customer} as new customer without generated Id
	 * @return {@link Customer}
	 */
	public Customer createNewCustomer() {
		Customer customer = new Customer();
		customer.setAddress("testAddress");
		customer.setEmail("test@test.com");
		customer.setName("Test");
		return customer;
	}
	
	/**
	 * Create {@link Customer} as saved customer
	 * @return {@link Customer}
	 */
	public Customer createSavedCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setVersion(0L);
		customer.setAddress("testAddress");
		customer.setEmail("test@test.com");
		customer.setName("Test");
		return customer;
	}
	
	/**
	 * Create {@link CustomerEntity} as saved customer
	 * @return {@link CustomerEntity}
	 */
	public CustomerEntity createSavedCustomerEntity() {
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1L);
		customer.setVersion(0L);
		customer.setAddress("testAddress");
		customer.setEmail("test@test.com");
		customer.setName("Test");
		return customer;
	}
	
	

}
