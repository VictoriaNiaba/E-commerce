package com.ecommerce.backend.products.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String image;

	private String images;

	private String description;

	private String shortDescription;

	private double price;

	private int quantity;

	private Long categoryId;
	
}
