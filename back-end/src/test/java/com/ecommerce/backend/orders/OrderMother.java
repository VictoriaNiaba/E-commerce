package com.ecommerce.backend.orders;

import java.util.Collection;

import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.users.UserMother;
import com.ecommerce.backend.users.model.User;
import com.google.common.collect.ImmutableList;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class OrderMother {

	private long autoIncrementId = 1L;

	public Order anEmptyOrder() {

		User user = UserMother.aUserWithNoOrders();

		Order order = Order.builder()
				.id(autoIncrementId++)
				.user(user)
				.build();

		user.setOrders(ImmutableList.of(order));

		log.info(order.toString());

		return order;
	}

	public Order anOrder() {
		// Création de la commande
		Order order = OrderMother.anEmptyOrder();

		// Création de détails de commande
		Collection<OrderDetails> orderDetails = OrderDetailsMother.aOrderDetailsCollection();

		// Association commande <-> détails de commande
		orderDetails.forEach(orderDetail -> orderDetail.setOrder(order));
		order.setDetails(orderDetails);

		log.info(order.toString());

		return order;
	}
}
