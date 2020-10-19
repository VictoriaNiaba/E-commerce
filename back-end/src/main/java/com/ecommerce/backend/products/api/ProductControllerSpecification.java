package com.ecommerce.backend.products.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ecommerce.backend.products.model.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Interface regroupant les annotations responsables de la génération de la
 * documentation Open Api v3.X du contrôleur ProductControllerREST.
 */
@Tag(name = "Product management")
public interface ProductControllerSpecification {

	@Operation(
		summary = "Find all Products",
		description = "Allow pagination and sorting",
		tags = { "products" }
	)
	public ResponseEntity<Page<Product>> findAllProducts(Pageable pageable);
}
