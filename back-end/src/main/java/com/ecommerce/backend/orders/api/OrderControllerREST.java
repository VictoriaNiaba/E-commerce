package com.ecommerce.backend.orders.api;

import java.util.Map;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.core.exceptionhandling.exceptions.EntityNotFoundException;
import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.orders.services.OrderMapper;
import com.ecommerce.backend.orders.services.OrderRepository;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/orders".
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/orders", produces = "application/json")
public class OrderControllerREST implements OrderControllerSpecification {

	private @Autowired OrderRepository orderRepository;
	private @Autowired OrderMapper orderMapper;

	@Override
	@GetMapping("")
	@PageableAsQueryParam
	public ResponseEntity<Page<OrderDto>> findAllOrders(@Parameter(hidden = true) Pageable pageable) {
		Page<OrderDto> ordersDto = orderRepository.findAll(pageable)
				.map(orderMapper::toDto);

		return ResponseEntity.ok().body(ordersDto);
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> findOrderById(@PathVariable("id") Long id) {
		OrderDto ordersDto = orderRepository.findById(id).map(orderMapper::toDto)
				.orElseThrow(() -> new EntityNotFoundException(Order.class, Map.of("id", id)));

		return ResponseEntity.ok().body(ordersDto);
	}
}
