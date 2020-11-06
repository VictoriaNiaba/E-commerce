package com.ecommerce.backend.orders.services;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.backend.orders.api.OrderDetailsDto;
import com.ecommerce.backend.orders.model.OrderDetails;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderDetailsMapper {

	@Mapping(source = "product.title", target = "productTitle")
	@Mapping(source = "product.description", target = "productDescription")
	@Mapping(source = "product.price", target = "productPrice")
	public OrderDetailsDto toDto(OrderDetails domain);

}