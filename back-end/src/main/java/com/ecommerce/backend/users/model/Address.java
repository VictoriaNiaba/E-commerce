package com.ecommerce.backend.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 255, nullable = true)
	private String line1;

	@Column(length = 255, nullable = true)
	private String line2;

	@Column(length = 45, nullable = true)
	private String city;

	@Column(length = 45, nullable = true)
	private String state;

	@Column(length = 45, nullable = true)
	private String country;

	@Column(length = 10, nullable = true)
	private String phone;

	@Column(length = 6, nullable = true, name = "pincode")
	private int pinCode;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;
}