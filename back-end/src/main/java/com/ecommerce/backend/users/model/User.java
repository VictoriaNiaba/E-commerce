package com.ecommerce.backend.users.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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

import org.hibernate.annotations.UpdateTimestamp;

import com.ecommerce.backend.orders.model.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* TODO: spécifier les valeurs par défaut en s'inspirant de 
 * celles décrites dans les schémas de la BDD. */
@Builder
@Getter @Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@ToString.Include
	private Long id;
	
	@UpdateTimestamp
	@Column(nullable = true)
	private Date modificationDate;

	@ToString.Include
	@Column(length = 255, nullable = false)
	private String username;

	@Column(length = 255, nullable = false)
	private String password;

	@ToString.Include
	@Column(length = 255, nullable = false)
	private String email;

	@ToString.Include
	@Column(length = 255, nullable = true, name = "fname")
	private String firstName;

	@ToString.Include
	@Column(length = 255, nullable = true, name = "lname")
	private String lastName;

	@ToString.Include
	@Column(length = 10, nullable = true)
	private Integer age;

	@ToString.Include
	@Column(length = 10, nullable = true)
	private Integer role;

	@Column(nullable = true, name = "photo_url")
	private String photoUrl;

	@ToString.Include
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
