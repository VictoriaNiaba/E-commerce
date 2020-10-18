package com.ecommerce.backend.products.api;

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

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/products". // repondre au requête utilisateurs et choisir les routes ect
 * ...
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/products", produces = "application/json")
public class ProductControllerREST {

	private @Autowired ProductRepository productRepository;

	@GetMapping("")
	public ResponseEntity<Page<Product>> getAll(Pageable pageable) {
		Page<Product> products = productRepository.findAll(pageable);
		return ResponseEntity.ok().body(products);
	}
}
