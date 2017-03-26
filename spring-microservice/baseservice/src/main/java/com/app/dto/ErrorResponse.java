package com.app.dto;

/**
 * Error object to respond to client in case of any errors at the service
 * the <tt>ErrorResponse</tt> contains an errorCode and errorMessage
 * 
 * @author seetha.bellamkonda
 *
 */
public class ErrorResponse {
	
	private String errorCode;
	private String errorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	

}
