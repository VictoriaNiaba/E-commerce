package com.ecommerce.backend.products;

import com.ecommerce.backend.products.model.Category;
import com.ecommerce.backend.products.model.Product;
import com.google.common.collect.ImmutableList;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class CategoryMother {
	
	private long autoIncrementId = 1L;

	public Category aFruitCategory() {
		Product banana = ProductMother.aBananaProduct();
		Product apple = ProductMother.anAppleProduct();
		
		Category fruits = Category.builder()
				.id(autoIncrementId++)
				.title("Fruits")
				.products(ImmutableList.of(banana, apple))
				.build();
		
		banana.setCategory(fruits);
		apple.setCategory(fruits);
		
		log.info(fruits.toString());

		return fruits;
	}
}
