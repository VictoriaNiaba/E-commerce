package com.ecommerce.backend.products;

import com.ecommerce.backend.products.model.Category;
import com.ecommerce.backend.products.model.Category.CategoryBuilder;
import com.ecommerce.backend.products.model.Product;
import com.google.common.collect.ImmutableList;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class CategoryMother {
	
	private long autoIncrementId = 1L;

	public CategoryBuilder aFruitCategory() {
		Category fruits = Category.builder()
				.id(autoIncrementId++)
				.title("Fruits")
				.build();
		
		Product banana = ProductMother.aBananaProduct().category(fruits).build();
		Product apple = ProductMother.anAppleProduct().category(fruits).build();
		
		CategoryBuilder fruitsBuilder = fruits.toBuilder().products(ImmutableList.of(banana, apple));
		
		log.info(fruitsBuilder.toString());

		return fruitsBuilder;
	}
}
