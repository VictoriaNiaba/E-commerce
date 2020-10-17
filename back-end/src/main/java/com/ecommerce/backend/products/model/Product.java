package com.ecommerce.backend.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private String title;
	
	private String image;
	
	private String images;
	
	private String description;
	
	@Column(name = "short_desc")
	private String shortDescription;
	
	private double price;
	
	private int quantity;
	
	@Column(name = "cat_id")
	private int categoryId;
}
