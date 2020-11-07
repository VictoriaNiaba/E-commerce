package com.ecommerce.backend.orders;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.backend.orders.api.OrderDetailsDto;
import com.ecommerce.backend.orders.model.OrderDetails;
import com.ecommerce.backend.orders.services.OrderDetailsMapper;
import com.ecommerce.backend.orders.services.OrderDetailsMapperImpl;

@SpringBootTest(classes = { OrderDetailsMapperImpl.class })
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OrderDetailsMapperUnitTest {

	private @Autowired OrderDetailsMapper orderDetailsMapper;

	/**
	 * Instancie une commande et son contenu, la convertit en DTO et vérifie que la
	 * conversion s'est bien déroulée.
	 */
	@Test
	void givenDomainToDto_whenMaps_thenCorrect() {
		// ------------------------------ Given ------------------------------//
		OrderDetails appleOrderDetails = OrderDetailsMother.anAppleOrderDetails();

		OrderDetailsDto expected = OrderDetailsDto.builder()
				.productTitle(appleOrderDetails.getProduct().getTitle())
				.productDescription(appleOrderDetails.getProduct().getDescription())
				.productPrice(appleOrderDetails.getProduct().getPrice())
				.quantity(appleOrderDetails.getQuantity())
				.build();

		// ------------------------------ When ------------------------------//
		OrderDetailsDto actual = orderDetailsMapper.toDto(appleOrderDetails);

		// ------------------------------ Then ------------------------------//
		assertThat(actual).isEqualTo(expected);
	}
}
