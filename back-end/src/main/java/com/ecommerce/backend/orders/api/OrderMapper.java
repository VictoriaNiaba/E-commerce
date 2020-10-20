package com.ecommerce.backend.orders.api;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.NotImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.core.Mapper;
import com.ecommerce.backend.orders.model.Order;

@Service
public class OrderMapper implements Mapper<Order, OrderDto> {

	private @Autowired ModelMapper modelMapper;

	@PostConstruct
	public void updateTypeMap() {
		modelMapper.createTypeMap(Order.class, OrderDto.class)
				.<String>addMapping(src -> src.getUser().getUsername(),
						(dest, value) -> dest.setUsername(value));
	}

	@Override
	public OrderDto toDto(Order domain) {
		return modelMapper.map(domain, OrderDto.class);
	}

	@Override
	public Order toDomain(OrderDto dto) {
		throw new NotImplementedException("Not implemented yet.");
	}
}