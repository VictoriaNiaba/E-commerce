package com.ecommerce.backend.users;

import com.ecommerce.backend.users.model.Address;
import com.ecommerce.backend.users.model.AuthenticationType;
import com.ecommerce.backend.users.model.User;
import com.ecommerce.backend.users.model.User.UserBuilder;
import com.google.common.collect.ImmutableList;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class UserMother {

	private long autoIncrementId = 1L;

	public UserBuilder aUserWithNoOrders() {

		String firstName = "Nicolas";
		String lastName = "Desnoust";
		Address address = AddressMother.anAddress().build();

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
				.build();

		address.setUser(user);
		UserBuilder userBuilder = user.toBuilder()
				.addresses(ImmutableList.of(address));

		log.info(userBuilder.toString());

		return userBuilder;
	}

	private String buildFakeEmail(String firstName, String lastName) {
		return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
	}
}
