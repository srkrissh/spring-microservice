package com.app.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.app.dto.Order;
import com.app.entity.OrderEntity;

public class OrderObjectFactory {
	
	/**
	 * Create {@link List} of {@link Order}
	 * 
	 * @return {@link List}
	 */
	public List<Order> createOrderList() {
		List<Order> orders = new ArrayList<>();
		for (int i = 0; i<2; i++) {
			Order order = new Order();
			order.setId(1L + i);
			order.setVersion(0L);
			order.setCustomerId(1L);
			order.setDescription("Test Order");
			order.setName("Test");
			order.setValue(BigDecimal.valueOf(10));
			orders.add(order);
		}
		return orders;
	}
	
	/**
	 * Create {@link List} of {@link OrderEntity}
	 * 
	 * @return {@link List}
	 */
	public List<OrderEntity> createOrderEntityList() {
		List<OrderEntity> orders = new ArrayList<>();
		orders.add(new OrderEntity());
		orders.add(new OrderEntity());
		return orders;
	}

}
