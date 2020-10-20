package com.ecommerce.backend.orders.api;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productId;

	private int quantity;
}
