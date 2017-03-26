package com.app.ws.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.User;
import com.app.service.UserService;

/**
 * Rest controller for users
 * 
 * @author seetha.bellamkonda
 *
 */
@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	private BCryptPasswordEncoder encoder;
	
	/**
	 * Autowire {@link BCryptPasswordEncoder}
	 * Hash the user password.
	 *  
	 * @param encoder
	 */
	@Autowired
	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	/**
	 * Create user
	 * @param user
	 * @return user details after creation.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword())); //Encrypt password
		User savedUser = userService.saveOrUpdate(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	/**
	 * Authenticate the user
	 * @param user
	 * @return true if user is authenticated otherwise false
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Boolean> authenticate(@RequestBody User user) {
		User savedUser = userService.findByUserName(user.getUserName());
		boolean authenticated = encoder.matches(user.getPassword(), savedUser.getPassword());
		return new ResponseEntity<>(authenticated, HttpStatus.OK);
	}
	
	/**
	 * Handle validation errors
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.toString());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

}
