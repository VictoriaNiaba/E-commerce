package com.ecommerce.backend.users;

import com.ecommerce.backend.users.model.Address;
import com.ecommerce.backend.users.model.AuthenticationType;
import com.ecommerce.backend.users.model.User;
import com.google.common.collect.ImmutableList;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class UserMother {

	private long autoIncrementId = 1L;

	public User aUserWithNoOrders() {

		String firstName = "Nicolas", lastName = "Desnoust";
		Address address = AddressMother.anAddress();

		User user = User.builder()
				.id(autoIncrementId++)
				.firstName(firstName)
				.lastName(lastName)
				.age(22)
				.email(buildFakeEmail(firstName, lastName))
				.password("placeholder")
				.role(555)
				.username("Nico")
				.photoUrl("photoUrl")
				.authType(AuthenticationType.LOCAL)
				.addresses(ImmutableList.of(address))
				.build();

		address.setUser(user);

		log.info(user.toString());

		return user;
	}

	private String buildFakeEmail(String firstName, String lastName) {
		return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
	}
}
