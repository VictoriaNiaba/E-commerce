package com.ecommerce.backend.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ecommerce.backend.orders.api.OrderDetailsDto;
import com.ecommerce.backend.orders.api.OrderDto;
import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.orders.services.OrderDetailsMapper;
import com.ecommerce.backend.orders.services.OrderMapper;
import com.ecommerce.backend.orders.services.OrderMapperImpl;
import com.ecommerce.backend.products.model.Category;
import com.ecommerce.backend.products.model.Product;
import com.ecommerce.backend.users.model.User;
import com.google.common.collect.ImmutableMap;

@SpringBootTest(classes = { OrderMapperImpl.class })
@ExtendWith(MockitoExtension.class)
class OrderMapperUnitTest {

	private @Autowired OrderMapper orderMapper;
	private @MockBean OrderDetailsMapper orderDetailsMapper;

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

		String bananaDesc = "This is a banana.";
		Product banana = Product.builder()
				.id(2L)
				.title("Banana")
				.image("http://www.banana-fake-link.com")
				.description(bananaDesc)
				.shortDescription(bananaDesc)
				.price(1)
				.quantity(80)
				.category(category)
				.build();

		OrderDetails appleOrderDetails = OrderDetails.builder()
				.id(1L)
				.product(apple)
				.quantity(1)
				.build();

		OrderDetails bananaOrderDetails = OrderDetails.builder()
				.id(2L)
				.product(banana)
				.quantity(1)
				.build();

		Map<String, OrderDetails> detailsMap = ImmutableMap.of(
				appleOrderDetails.getProduct().getTitle(), appleOrderDetails,
				bananaOrderDetails.getProduct().getTitle(), bananaOrderDetails);

		Order order = Order.builder()
				.id(1L)
				.user(new User())
				.details(detailsMap.values())
				.build();

		OrderDetailsDto appleOrderDetailsDto = OrderDetailsDto.builder()
				.productTitle(apple.getTitle())
				.productDescription(apple.getDescription())
				.productPrice(apple.getPrice())
				.quantity(appleOrderDetails.getQuantity())
				.build();

		OrderDetailsDto bananaOrderDetailsDto = OrderDetailsDto.builder()
				.productTitle(banana.getTitle())
				.productDescription(banana.getDescription())
				.productPrice(banana.getPrice())
				.quantity(bananaOrderDetails.getQuantity())
				.build();

		// ------------------------------ When ------------------------------//
		when(orderDetailsMapper.toDto(appleOrderDetails)).thenReturn(appleOrderDetailsDto);
		when(orderDetailsMapper.toDto(bananaOrderDetails)).thenReturn(bananaOrderDetailsDto);
		OrderDto orderDto = orderMapper.toDto(order);

		// ------------------------------ Then ------------------------------//
		assertEquals(order.getUser().getUsername(), orderDto.getUsername());
		assertEquals(order.getId(), orderDto.getId());
		for (OrderDetailsDto orderDetailDto : orderDto.getDetails()) {
			OrderDetails orderDetail = detailsMap.get(orderDetailDto.getProductTitle());

			assertEquals(orderDetail.getProduct().getTitle(), orderDetailDto.getProductTitle());
			assertEquals(orderDetail.getProduct().getDescription(), orderDetailDto.getProductDescription());
			assertEquals(orderDetail.getProduct().getPrice(), orderDetailDto.getProductPrice());
			assertEquals(orderDetail.getQuantity(), orderDetailDto.getQuantity());
		}
	}
}
