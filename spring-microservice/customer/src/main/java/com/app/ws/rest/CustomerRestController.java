package com.app.ws.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Customer;
import com.app.dto.ErrorResponse;
import com.app.service.CustomerService;

/**
 * Rest controller for Customer
 * 
 * @author seetha.bellamkonda
 *
 */
@RestController
public class CustomerRestController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerRestController.class);

	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * Create customer
	 * 
	 * @param customer
	 * @return customer created with id
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		LOGGER.debug("createCustomer {}", customer);
		
		Customer savedCustomer = customerService.saveOrUpdate(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
	}
	
	
	/**
	 * Handles field validation errors
	 * 
	 * @param ex {@link MethodArgumentNotValidException}
	 * @return {@link ErrorResponse} with customer error code and error message.
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.toString());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
