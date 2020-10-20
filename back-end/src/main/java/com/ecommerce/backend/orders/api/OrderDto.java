package com.ecommerce.backend.orders.api;

import java.io.Serializable;
import java.util.Collection;

import lombok.Data;

@Data
public class OrderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String userId;

	private Collection<OrderDetailsDto> details;
}
