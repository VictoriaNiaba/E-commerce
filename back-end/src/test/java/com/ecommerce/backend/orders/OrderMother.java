package com.ecommerce.backend.orders;

import com.ecommerce.backend.orders.model.Order;
import com.ecommerce.backend.users.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderMother {

	private OrderMother() {
	}

	public static Order createUser() {
		Order order = Order.builder()
				.id(1L)
				.user(new User())
				.details(detailsMap.values())
				.build();

		log.info(order.toString());

		return order;
	}
//
//	    public static UserRegistration createUserWithNotValidPassword() {
//	        UserRegistration userRegistration = UserRegistration.builder().
//	            name("Test user - not valid password").
//	            email("notValidPassword@gmail.com").
//	            password("12345678").
//	            dateOfBirth(LocalDate.of(1996, 12, 2))
//	            .build();
//
//	        LOG.info(userRegistration);
//
//	        return userRegistration;
//	    }
//
//	    public static UserRegistration createUserWithNotValidEmail() {
//	        UserRegistration userRegistration = UserRegistration.builder().
//	            name("Test user - not valid email").
//	            email("emailNotValid").
//	            password("1q2w3e4rT").
//	            dateOfBirth(LocalDate.of(1989, 10, 21))
//	            .build();
//
//	        LOG.info(userRegistration);
//
//	        return userRegistration;
//	    }
//
//	    public static UserRegistration createUserNotValidDateOfBirth() {
//	        UserRegistration userRegistration = UserRegistration.builder().
//	            name("Test user - not valid birth date").
//	            email("notValidBirthDate@gmail.com").
//	            password("4r3e2w1qQ").
//	            dateOfBirth(LocalDate.of(2030, 12, 31))
//	            .build();
//
//	        LOG.info(userRegistration);
//
//	        return userRegistration;
//	    }

}
