package com.ecommerce.backend.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.backend.orders.api.OrderDetailsDto;
import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.orders.services.OrderDetailsMapper;
import com.ecommerce.backend.orders.services.OrderDetailsMapperImpl;
import com.ecommerce.backend.products.model.Category;
import com.ecommerce.backend.products.model.Product;

@SpringBootTest(classes = { OrderDetailsMapperImpl.class })
@ExtendWith(MockitoExtension.class)
class OrderDetailsMapperUnitTest {

	private @Autowired OrderDetailsMapper orderDetailsMapper;

	/**
	 * Instancie une commande et son contenu, la convertit en DTO et vérifie que la
	 * conversion s'est bien déroulée.
	 */
	@Test
	void givenDomainToDto_whenMaps_thenCorrect() {
		// ------------------------------ Given ------------------------------//
		Category category = Category.builder()
				.id(1L)
				.title("Fruits")
				.build();

		String appleDesc = "This is an apple.";
		Product apple = Product.builder()
				.id(1L)
				.title("Apple")
				.image("http://www.apple-fake-link.com")
				.description(appleDesc)
				.shortDescription(appleDesc)
				.price(1.50)
				.quantity(100)
				.category(category)
				.build();

		OrderDetails appleOrderDetails = OrderDetails.builder()
				.id(1L)
				.product(apple)
				.quantity(1)
				.build();

		OrderDetailsDto expected = OrderDetailsDto.builder()
				.productTitle(apple.getTitle())
				.productDescription(apple.getDescription())
				.productPrice(apple.getPrice())
				.quantity(appleOrderDetails.getQuantity())
				.build();

		// ------------------------------ When ------------------------------//
		OrderDetailsDto actual = orderDetailsMapper.toDto(appleOrderDetails);

		// ------------------------------ Then ------------------------------//
		assertEquals(expected, actual);
	}
}
