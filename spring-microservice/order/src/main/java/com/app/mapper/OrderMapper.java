package com.app.mapper;

import org.springframework.stereotype.Component;

import com.app.dto.Order;
import com.app.entity.OrderEntity;
import com.app.entity.embeddable.Amount;
import com.app.util.Currency;

/**
 * Mapper for order
 * 
 * @author Seetharama Krishna
 *
 */
@Component
public class OrderMapper implements BaseMapper<Order, OrderEntity> {
	
	@Override
	public Order mapEntityToDto(OrderEntity entity) {
		if (entity == null) {
			return null;
		}
		Order order = new Order();
		baseMappingEntityToDto(order, entity);
		order.setName(entity.getName());
		order.setDescription(entity.getDescription());
		order.setValue(entity.getValue().getAmount());
		order.setCustomerId(entity.getCustomerId());
		return order;
	}

	@Override
	public OrderEntity mapDtoToEntity(Order dto) {
		OrderEntity entity = new OrderEntity();
		baseMappingDtoToEntity(dto, entity);
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		Amount amount = new Amount();
		amount.setAmount(dto.getValue());
		amount.setCurrencyCode(Currency.USD.name());
		entity.setValue(amount);
		entity.setCustomerId(dto.getCustomerId());
		return entity;
	}

}
