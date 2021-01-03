package com.ecommerce.backend.products.services;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.ecommerce.backend.products.api.CategoryDto;
import com.ecommerce.backend.products.model.Category;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {
    
	public CategoryDto toDto(Category category);
}