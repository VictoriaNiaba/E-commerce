package com.ecommerce.backend.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//TODO(victoria): Ajouter les annotations de JPA manquantes
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
	
	// TODO(victoria): Remplacer la clé étrangère par une relation entre objets
	@Column(name = "cat_id")
	private int categoryId;
}
