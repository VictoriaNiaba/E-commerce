package com.ecommerce.backend.users.model;

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

@Builder(toBuilder = true)
@Getter @Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@ToString.Include
	private Long id;

	@ToString.Include
	@Column(length = 255, nullable = true)
	private String line1;

	@ToString.Include
	@Column(length = 255, nullable = true)
	private String line2;

	@ToString.Include
	@Column(length = 45, nullable = true)
	private String city;

	@ToString.Include
	@Column(length = 45, nullable = true)
	private String state;

	@ToString.Include
	@Column(length = 45, nullable = true)
	private String country;

	@ToString.Include
	@Column(length = 10, nullable = true)
	private String phone;

	@ToString.Include
	@Column(length = 6, nullable = true, name = "pincode")
	private int pinCode;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
}