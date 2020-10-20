package com.ecommerce.backend.orders.api;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value @Builder
public class OrderDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(
		description = "Unique identifier of the ordered product.",
		example = "2",
		required = true
	)
	private int productId;

	@Schema(
			description = "Quantity of the ordered product.",
			example = "1",
			required = true
	)
	private int quantity;
}
