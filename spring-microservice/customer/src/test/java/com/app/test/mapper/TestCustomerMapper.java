package com.app.test.mapper;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.app.dto.Customer;
import com.app.entity.CustomerEntity;
import com.app.mapper.CustomerMapper;
import com.app.util.CustomerObjectFactory;

/**
 * 
 * Tests {@link CustomerMapper}
 * 
 * @author seetha.bellamkonda
 *
 */
public class TestCustomerMapper {
	
	private CustomerObjectFactory factory;
	private CustomerMapper customerMapper;
	
	@Before
	public void setUp()
	{
		factory = new CustomerObjectFactory();
		customerMapper = new CustomerMapper();
	}
	
	@Test
	public void testMapDtoToEntity() {
		Customer savedCustomer = factory.createSavedCustomer();
		CustomerEntity customerEntity = customerMapper.mapDtoToEntity(savedCustomer);
		assertEquals(customerEntity.getId(), savedCustomer.getId());
		assertEquals(customerEntity.getEmail(), savedCustomer.getEmail());
		assertEquals(customerEntity.getName(), savedCustomer.getName());
		assertEquals(customerEntity.getAddress(), savedCustomer.getAddress());
	}
	
	@Test
	public void testMapEntityToDTO() {
		CustomerEntity customerEntity = factory.createSavedCustomerEntity();
		Customer customer = customerMapper.mapEntityToDto(customerEntity);
		assertEquals(customer.getId(), customerEntity.getId());
		assertEquals(customer.getEmail(), customerEntity.getEmail());
		assertEquals(customer.getName(), customerEntity.getName());
		assertEquals(customer.getAddress(), customerEntity.getAddress());
	}
}
