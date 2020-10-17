package com.ecommerce.backend.products.model;

import lombok.Data;

@Data
public class Product {
	private int id;
	private String title;
	private String image;
	private String images;
	private String description;
	private String shortDescription;
	private double price;
	private int quantity;
	private int categoryId;
}
