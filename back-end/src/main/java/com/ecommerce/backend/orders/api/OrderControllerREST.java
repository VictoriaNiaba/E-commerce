package com.ecommerce.backend.orders.api;

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
import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.orders.services.OrderRepository;

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/orders".
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/orders", produces = "application/json")
public class OrderControllerREST {

	private @Autowired OrderRepository orderRepository;
	private @Autowired PageMapper<Order> pageMapper;

	@GetMapping("")
	public ResponseEntity<CustomPage<Order>> getAll(Pageable pageable) {
		Page<Order> results = orderRepository.findAll(pageable);
		CustomPage<Order> orders = pageMapper.toCustomPage(results); 

		return ResponseEntity.ok().body(orders);
	}
}
