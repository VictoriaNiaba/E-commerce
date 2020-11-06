package com.ecommerce.backend.products;

import com.ecommerce.backend.products.model.Product;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class ProductMother {

	private long autoIncrementId = 1L;

	public Product aBananaProduct() {
		String description = "This is a banana.";

		Product banana = Product.builder()
				.id(autoIncrementId++)
				.title("Banana")
				.image("http://www.banana-fake-link.com")
				.description(description)
				.shortDescription(description)
				.price(1)
				.quantity(80)
				.build();

		log.info(banana.toString());

		return banana;
	}

	public Product anAppleProduct() {
		String description = "This is an apple.";

		Product apple = Product.builder()
				.id(autoIncrementId++)
				.title("Apple")
				.image("http://www.apple-fake-link.com")
				.description(description)
				.shortDescription(description)
				.price(1.50)
				.quantity(100)
				.build();
		
		log.info(apple.toString());

		return apple;
	}
}
