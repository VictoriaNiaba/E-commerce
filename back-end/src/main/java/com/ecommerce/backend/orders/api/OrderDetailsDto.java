package com.ecommerce.backend.orders.api;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder 
@NoArgsConstructor @AllArgsConstructor
public class OrderDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(
		description = "Unique identifier of the ordered product.",
		example = "2",
		required = true
	)
	private String productTitle;
	
	@Schema(
		description = "Unique identifier of the ordered product.",
		example = "2",
		required = true
	)
	private String productDescription;
	
	@Schema(
		description = "Unique identifier of the ordered product.",
		example = "2",
		required = true
	)
	private double productPrice;

	@Schema(
			description = "Quantity of the ordered product.",
			example = "1",
			required = true
	)
	private int quantity;
}
