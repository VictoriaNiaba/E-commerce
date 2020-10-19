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

import com.ecommerce.backend.products.model.Product;
import com.ecommerce.backend.products.services.ProductRepository;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/products".
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "products", produces = "application/json")
public class ProductControllerREST implements ProductControllerSpecification {

	private @Autowired ProductRepository productRepository;

	@GetMapping("")
	@PageableAsQueryParam
	public ResponseEntity<Page<Product>> findAllProducts(@Parameter(hidden = true) Pageable pageable) {
		Page<Product> products = productRepository.findAll(pageable);
		return ResponseEntity.ok().body(products);
	}
}