package com.ecommerce.backend.products.services;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.backend.products.api.CategoryDto;
import com.ecommerce.backend.products.model.Category;
import com.ecommerce.backend.products.model.Product;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {

	@Mapping(source = "products", target = "productIds")
	public CategoryDto toDto(Category category);

	default Long productToProductId(Product product) {
		return product.getId();
	}
}