package com.ecommerce.backend.orders;

import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.products.ProductMother;
import com.ecommerce.backend.products.model.Product;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class OrderDetailsMother {
	
	private long autoIncrementId = 1L;

	public OrderDetails createBananaOrderDetails() {
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
