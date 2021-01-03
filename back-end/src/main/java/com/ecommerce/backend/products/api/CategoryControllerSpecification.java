package com.ecommerce.backend.products.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Interface regroupant les annotations responsables de la génération de la
 * documentation Open Api v3.X du contrôleur CategoryControllerREST.
 */
@Tag(name = "Category management")
public interface CategoryControllerSpecification {

	@Operation(
		summary = "Find all Categories",
		description = "Allow pagination and sorting",
		tags = { "categories" }
	)
	public ResponseEntity<Page<CategoryDto>> findAllCategories(Pageable pageable);
}
