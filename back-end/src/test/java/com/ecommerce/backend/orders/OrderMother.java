package com.ecommerce.backend.orders;

import java.util.Collection;

import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.orders.model.Order.OrderBuilder;
import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.products.CategoryMother;
import com.ecommerce.backend.products.model.Category;
import com.ecommerce.backend.products.model.Product;
import com.ecommerce.backend.users.UserMother;
import com.ecommerce.backend.users.model.User;
import com.google.common.collect.ImmutableList;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class OrderMother {

	private long autoIncrementId = 1L;

	public OrderBuilder anEmptyOrder() {

		Order order = Order.builder()
				.id(autoIncrementId++)
				.build();

		User user = UserMother.aUserWithNoOrders()
				.orders(ImmutableList.of(order))
				.build();

		OrderBuilder orderBuilder = order.toBuilder()
				.user(user);

		log.info(orderBuilder.toString());

		return orderBuilder;
	}

	public OrderBuilder anOrder() {
		// Création de la commande
		Order order = OrderMother.anEmptyOrder().build();

		// Création et association des dépendances
		OrderDetails bananaOrderDetails = OrderDetailsMother.createBananaOrderDetails()
				.order(order)
				.build();
		OrderDetails appleOrderDetails = OrderDetailsMother.createAppleOrderDetails()
				.order(order)
				.build();
		Category fruits = CategoryMother.aFruitCategory().build();
		Product banana = bananaOrderDetails.getProduct(), apple = appleOrderDetails.getProduct();
		fruits.setProducts(ImmutableList.of(banana, apple));
		banana.setCategory(fruits);
		apple.setCategory(fruits);
		Collection<OrderDetails> orderDetails = ImmutableList.of(bananaOrderDetails, appleOrderDetails);

		// Définition des associations commande <-> dépendances
		OrderBuilder orderBuilder = order.toBuilder()
				.details(orderDetails);

		log.info(orderBuilder.toString());

		return orderBuilder;
	}
}
