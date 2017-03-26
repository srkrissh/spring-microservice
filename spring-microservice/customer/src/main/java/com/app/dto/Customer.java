package com.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Customer information
 * 
 * @author Seetharama Krishna
 *
 */
public class Customer extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5398077190552126110L;
	
	@NotNull
	private String name;
	
	@NotNull
	@Size(max = 100)
	private String email;
	
	@Size(max = 200)
	private String address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		Customer c = (Customer) o;
		return c.getEmail() != null && this.getEmail() != null && c.getEmail().equalsIgnoreCase(this.getEmail());
	}
	
	@Override
	public int hashCode() {
		return 31 * (this.getEmail() == null ? 0 : this.getEmail().hashCode()) + 17;  
	}
	
	@Override
	public String toString() {
		return String.format("Customer -> name: %s, email: %s", this.name, this.email);
	}
	
	
	

}
