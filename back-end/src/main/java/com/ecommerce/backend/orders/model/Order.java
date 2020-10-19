package com.ecommerce.backend.orders.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ecommerce.backend.users.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	@JsonIgnore // TODO: à remplacer par l'id du user
	private User user;

	@OneToMany(cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	}, fetch = FetchType.LAZY, mappedBy = "order")
	@JsonIgnore // TODO: à remplacer
	private Collection<OrderDetails> details;
}
