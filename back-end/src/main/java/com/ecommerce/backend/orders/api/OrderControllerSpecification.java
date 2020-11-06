package com.ecommerce.backend.orders.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Interface regroupant les annotations responsables de la génération de la
 * documentation Open Api v3.X du contrôleur OrderControllerREST.
 * 
 * exemple de doc :
 * https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/
 */
@Tag(name = "Order management")
public interface OrderControllerSpecification {

	@Operation(
		summary = "Find all Orders", 
		description = "Allow pagination and sorting", 
		tags = { "orders" }
	)
	public ResponseEntity<Page<OrderDto>> findAllOrders(Pageable pageable);

	@Operation(
		summary = "Find an Order by id", 
		description = "Allow pagination and sorting", 
		tags = { "order" }
	)
	public ResponseEntity<OrderDto> findOrderById(Long id);
}
