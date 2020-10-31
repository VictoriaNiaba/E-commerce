package com.ecommerce.backend.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString(of= {"id", "title", "price", "quantity"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(length = 255, nullable = false)
	private String title;

	@Column(length = 255, nullable = false)
	private String image;

	@Column(nullable = true)
	private String images;

	@Column(nullable = false)
	private String description;

	@Column(length = 255, nullable = false, name = "short_desc")
	private String shortDescription;

	@Column(nullable = false)
	private double price;

	@Column(length = 10, nullable = false)
	private int quantity;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_id")
	private Category category;

//	@OneToMany(cascade = {
//			CascadeType.MERGE,
//			CascadeType.PERSIST,
//			CascadeType.REMOVE
//	}, fetch = FetchType.LAZY, mappedBy = "product")
//	private Collection<OrderDetails> orderDetails;
}
