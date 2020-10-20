package com.ecommerce.backend.users.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ecommerce.backend.orders.model.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* TODO: spécifier les valeurs par défaut en s'inspirant de 
 * celles décrites dans les schémas de la BDD. */
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 255, nullable = false)
	private String username;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 255, nullable = true, name = "fname")
	private String firstName;

	@Column(length = 255, nullable = true, name = "lname")
	private String lastName;

	@Column(length = 10, nullable = true)
	private int age;

	@Column(length = 10, nullable = true)
	private int role;

	@Column(nullable = true, name = "photo_url")
	private String photoUrl;

	@Enumerated(EnumType.STRING)
	@Column(length = 255, nullable = false, name = "type")
	private AuthenticationType authType;

	@OneToMany(cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	}, fetch = FetchType.LAZY, mappedBy = "user")
	private Collection<Order> orders;

	@OneToMany(cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	}, fetch = FetchType.LAZY, mappedBy = "user")
	private Collection<Address> addresses;
}
