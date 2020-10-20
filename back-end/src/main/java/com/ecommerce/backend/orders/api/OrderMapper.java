package com.ecommerce.backend.orders.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.core.Mapper;
import com.ecommerce.backend.orders.model.Order;

@Service
public class OrderMapper implements Mapper<Order, OrderDto> {

	private @Autowired ModelMapper modelMapper;

	@Override
	public OrderDto toDto(Order domain) {
		return modelMapper.map(domain, OrderDto.class);
	}

	@Override
	public Order toDomain(OrderDto dto) {
		return modelMapper.map(dto, Order.class);
	}
}