package com.ecommerce.backend.orders.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity @Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@ToString.Include
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ToString.Include
	@JoinColumn(name = "user_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User user;

	@OneToMany(cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	}, fetch = FetchType.EAGER, mappedBy = "order")
	private Collection<OrderDetails> details;
}
