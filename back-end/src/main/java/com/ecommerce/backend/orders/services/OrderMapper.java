package com.ecommerce.backend.orders.services;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.backend.orders.api.OrderDto;
import com.ecommerce.backend.orders.model.Order;

@Mapper(componentModel = "spring", uses = {
		OrderDetailsMapper.class }, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

	@Mapping(source = "user.username", target = "username")
	public OrderDto toDto(Order domain);

}