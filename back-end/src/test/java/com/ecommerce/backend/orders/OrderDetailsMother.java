package com.ecommerce.backend.orders;

import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.orders.model.OrderDetails.OrderDetailsBuilder;
import com.ecommerce.backend.products.ProductMother;
import com.ecommerce.backend.products.model.Product;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class OrderDetailsMother {
	
	private long autoIncrementId = 1L;

	public OrderDetailsBuilder createBananaOrderDetails() {
		Product banana = ProductMother.aBananaProduct().build();
	
		OrderDetailsBuilder bananaOrderDetailsBuilder = OrderDetails.builder()
				.id(autoIncrementId++)
				.product(banana)
				.quantity(1);

		log.info(bananaOrderDetailsBuilder.toString());

		return bananaOrderDetailsBuilder;
	}
	
	public OrderDetailsBuilder createAppleOrderDetails() {
		Product apple = ProductMother.anAppleProduct().build();
	
		OrderDetailsBuilder appleOrderDetailsBuilder = OrderDetails.builder()
				.id(autoIncrementId++)
				.product(apple)
				.quantity(1);

		log.info(appleOrderDetailsBuilder.toString());

		return appleOrderDetailsBuilder;
	}
}
