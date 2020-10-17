package com.ecommerce.backend.products.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	private @Autowired ProductRepository educationRepository;

	@GetMapping("")
	public ResponseEntity<Product[]> getAll() {
		Product[] products = new Product[0];

		return ResponseEntity.ok().body(products);
	}
}
