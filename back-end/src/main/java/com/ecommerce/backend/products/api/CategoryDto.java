package com.ecommerce.backend.products.api;

import java.io.Serializable;
import java.util.Collection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "Unique identifier of the category.", example = "2", required = true)
	private Long id;

	@Schema(description = "Title of the category.", example = "Shoes", required = true)
	private String title;

	private Collection<Long> productIds;
}
