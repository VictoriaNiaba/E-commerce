package com.ecommerce.backend.products.services;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.backend.products.api.ProductDto;
import com.ecommerce.backend.products.model.Product;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

	@Mapping(target="categoryId", source="category.id")	
	public ProductDto toDto(Product product);

}