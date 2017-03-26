package com.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User information
 * 
 * @author Seetharama Krishna
 *
 */
public class User extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386940874217135939L;
	
	@NotNull
	@Size(max = 100)
	private String userName;
	
	@NotNull
	@Size(max = 200)
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		User u = (User) obj;
		return u.getUserName() != null && this.getUserName() != null && this.getUserName().equalsIgnoreCase(u.getUserName());
	}
	
	@Override
	public int hashCode() {
		return 31 * (this.getUserName() == null ? 0 : this.getUserName().hashCode()) + 17;
	}

	

}
