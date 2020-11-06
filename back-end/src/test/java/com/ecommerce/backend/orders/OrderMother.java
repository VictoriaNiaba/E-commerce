package com.ecommerce.backend.orders;

import java.util.Collection;

import com.ecommerce.backend.orders.model.Order;
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

		// Création et association des dépendances
		OrderDetails bananaOrderDetails = OrderDetailsMother.createBananaOrderDetails()
				.toBuilder()
				.order(order)
				.build();
		OrderDetails appleOrderDetails = OrderDetailsMother.anAppleOrderDetails()
				.toBuilder()
				.order(order)
				.build();

		// Mise à jour des produits de la catégorie fruits pour garantir la cohésion des références
		Product banana = bananaOrderDetails.getProduct(), apple = appleOrderDetails.getProduct();
		Category fruits = CategoryMother.aFruitCategory();
		fruits.setProducts(ImmutableList.of(banana, apple));
		banana.setCategory(fruits);
		apple.setCategory(fruits);

		Collection<OrderDetails> orderDetails = ImmutableList.of(
				bananaOrderDetails, appleOrderDetails);

		// Définition des associations commande <-> dépendances
		order.toBuilder().details(orderDetails).build();

		log.info(order.toString());

		return order;
	}
}
