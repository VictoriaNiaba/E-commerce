package com.ecommerce.backend.orders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ecommerce.backend.orders.api.OrderDetailsDto;
import com.ecommerce.backend.orders.api.OrderDto;
import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.orders.services.OrderDetailsMapper;
import com.ecommerce.backend.orders.services.OrderMapper;
import com.ecommerce.backend.orders.services.OrderMapperImpl;
import com.google.common.collect.ImmutableList;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = { OrderMapperImpl.class })
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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
		Order order = OrderMother.anOrder();
		
		OrderDetailsDto fakeOrderDetailsDto = new OrderDetailsDto();
		OrderDto expected = OrderDto.builder()
				.id(order.getId())
				.username(order.getUser().getUsername())
				.details(ImmutableList.of(fakeOrderDetailsDto, fakeOrderDetailsDto))
				.build();
		
		// ------------------------------ When ------------------------------//
		order.getDetails().forEach(orderDetail -> {
			when(orderDetailsMapper.toDto(orderDetail)).thenReturn(fakeOrderDetailsDto);
		});
		OrderDto actual = orderMapper.toDto(order);

		// ------------------------------ Then ------------------------------//
		assertThat(actual).isEqualTo(expected);
		order.getDetails().forEach(orderDetail -> {
			verify(orderDetailsMapper, times(1)).toDto(orderDetail);
		});
	}
}
