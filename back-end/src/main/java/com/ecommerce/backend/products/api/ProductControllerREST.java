package com.ecommerce.backend.products.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.core.api.CustomPage;
import com.ecommerce.backend.core.services.PageMapper;
import com.ecommerce.backend.products.model.Product;
import com.ecommerce.backend.products.services.ProductRepository;

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/educations".
 * 
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/products", produces = "application/json")
public class ProductControllerREST {

	private @Autowired ProductRepository productRepository;
	private @Autowired PageMapper<Product> pageMapper;

	@GetMapping("")
	public ResponseEntity<CustomPage<Product>> getAll(Pageable pageable) {
		Page<Product> results = productRepository.findAll(pageable);
		CustomPage<Product> orders = pageMapper.toCustomPage(results);

		return ResponseEntity.ok().body(orders);
	}
}
