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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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
