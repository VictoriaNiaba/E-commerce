package com.ecommerce.backend.products.api;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.products.services.ProductMapper;
import com.ecommerce.backend.products.services.ProductRepository;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/products".
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/products", produces = "application/json")
public class ProductControllerREST implements ProductControllerSpecification {

	private @Autowired ProductRepository productRepository;
	private @Autowired ProductMapper productMapper;

	@Override
	@GetMapping("")
	@PageableAsQueryParam
	public ResponseEntity<Page<ProductDto>> findAll(@Parameter(hidden = true) Pageable pageable) {
		Page<ProductDto> products = productRepository.findAll(pageable)
				.map(productMapper::toDto);
		return ResponseEntity.ok().body(products);
	}

	@Override
	@PostMapping("_mGet")
	public ResponseEntity<Iterable<ProductDto>> findAllById(@RequestBody Iterable<Long> ids) {
		Iterable<ProductDto> products = StreamSupport
				.stream(productRepository.findAllById(ids).spliterator(), false)
				.map(productMapper::toDto)
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(products);
	}
}