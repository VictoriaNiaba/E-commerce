package com.ecommerce.backend.orders.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.core.services.CustomPage;
import com.ecommerce.backend.core.services.PageMapper;
import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.orders.services.OrderRepository;

/**
 * Contrôleur REST prenant en charge tous les endpoints commençant par la racine
 * "/orders".
 * 
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/orders", produces = "application/json")
public class OrderControllerREST {

	private @Autowired OrderRepository orderRepository;
	private @Autowired PageMapper<Order> pageMapper;

	@GetMapping("")
	public ResponseEntity<CustomPage<Order>> getAll(
		@RequestParam(value = "page", defaultValue = "0") int page,
		@RequestParam(value = "size", defaultValue = "10") int size,
		@RequestParam(value = "sort", defaultValue = "+id") String sort
	) {
		Pageable pagingRestriction = buildPagingRestrictions(page, size, sort);

		Page<Order> results = orderRepository.findAll(pagingRestriction);
		CustomPage<Order> orders = pageMapper.toDomain(results); 

		return ResponseEntity.ok().body(orders);
	}

	// TODO: Imposer un maximum sur size
	private Pageable buildPagingRestrictions(int page, int size, String sort) {
		char orderBySign = sort.charAt(0);
		if(orderBySign == '+' || orderBySign == '-') {
			sort = sort.substring(1);
		}
		else {
			orderBySign = '+';
		}
		Direction direction = (orderBySign == '+') ? Direction.ASC : Direction.DESC;
		Sort sortOption = Sort.by(direction, sort);
		
		return PageRequest.of(page, size, sortOption);
	}
}
