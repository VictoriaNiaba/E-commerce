package com.ecommerce.backend.products.api;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.products.services.CategoryMapper;
import com.ecommerce.backend.products.services.CategoryRepository;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/categories".
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/categories", produces = "application/json")
public class CategoryControllerREST implements CategoryControllerSpecification {

	private @Autowired CategoryRepository categoryRepository;
	private @Autowired CategoryMapper categoryMapper;

	@Override
	@GetMapping("")
	@PageableAsQueryParam
	public ResponseEntity<Page<CategoryDto>> findAllCategories(@Parameter(hidden = true) Pageable pageable) {
		Page<CategoryDto> categoriesDto = categoryRepository.findAll(pageable)
					.map(categoryMapper::toDto);

		return ResponseEntity.ok().body(categoriesDto);
	}
}