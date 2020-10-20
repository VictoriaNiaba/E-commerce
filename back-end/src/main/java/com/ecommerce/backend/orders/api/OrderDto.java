package com.ecommerce.backend.orders.api;

import java.io.Serializable;
import java.util.Collection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value @Builder
public class OrderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(
		description = "Unique identifier of the order.",
		example = "2",
		required = true
	)
	private int id;
	
	@Schema(
		description = "Unique identifier of the user who made the order.",
		example = "1",
		required = true
	)
	private int userId;

	@Schema(
		description = "Order details.",
		required = true
	)
	private Collection<OrderDetailsDto> details;
}
