package com.ecommerce.backend.orders;

import java.util.Collection;

import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.products.CategoryMother;
import com.ecommerce.backend.products.ProductMother;
import com.ecommerce.backend.products.model.Category;
import com.ecommerce.backend.products.model.Product;
import com.google.common.collect.ImmutableList;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class OrderDetailsMother {

	private long autoIncrementId = 1L;

	public Collection<OrderDetails> aOrderDetailsCollection() {
		OrderDetails bananaOrderDetails = OrderDetailsMother.aBananaOrderDetails();
		OrderDetails appleOrderDetails = OrderDetailsMother.anAppleOrderDetails();

		Product banana = bananaOrderDetails.getProduct();
		Product apple = appleOrderDetails.getProduct();
		Category fruits = CategoryMother.aFruitCategory().toBuilder()
				.products(ImmutableList.of(banana, apple))
				.build();
		banana.setCategory(fruits);
		apple.setCategory(fruits);

		Collection<OrderDetails> orderDetails = ImmutableList.of(
				bananaOrderDetails, appleOrderDetails);

		log.info(orderDetails.toString());

		return orderDetails;
	}

	public OrderDetails aBananaOrderDetails() {
		Product banana = ProductMother.aBananaProduct();

		OrderDetails bananaOrderDetails = OrderDetails.builder()
				.id(autoIncrementId++)
				.product(banana)
				.quantity(1)
				.build();

		log.info(bananaOrderDetails.toString());

		return bananaOrderDetails;
	}

	public OrderDetails anAppleOrderDetails() {
		Product apple = ProductMother.anAppleProduct();

		OrderDetails appleOrderDetails = OrderDetails.builder()
				.id(autoIncrementId++)
				.product(apple)
				.quantity(1)
				.build();

		log.info(appleOrderDetails.toString());

		return appleOrderDetails;
	}
}
