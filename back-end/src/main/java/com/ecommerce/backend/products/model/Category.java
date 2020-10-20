package com.ecommerce.backend.products.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(length = 255, nullable = false)
	private String title;

	@ToString.Exclude
	@OneToMany(cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	}, fetch = FetchType.LAZY, mappedBy = "category")
	private Collection<Product> products;
}
