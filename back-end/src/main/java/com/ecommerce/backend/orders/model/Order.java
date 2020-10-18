package com.ecommerce.backend.orders.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// TODO(victoria): Ajouter les annotations de JPA manquantes
@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	// TODO(victoria): Remplacer la clé étrangère par une relation entre objets
	@Column(name = "user_id")
	private int userId;
}
