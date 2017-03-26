package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.entity.embeddable.Amount;

/**
 * Order Entity
 * @author Seetharama Krishna
 *
 */
@Entity
@Table(name = "ORDERS")
public class OrderEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5371229184479854011L;
	
	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "ORDER_DESCRIPTION", length = 255)
	private String description;
	
	@Embedded
	private Amount value;
	
	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Amount getValue() {
		return value;
	}

	public void setValue(Amount value) {
		this.value = value;
	}

}
