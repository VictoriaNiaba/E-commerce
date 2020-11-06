package com.ecommerce.backend.users;

import com.ecommerce.backend.users.model.Address;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class AddressMother {
	
	private long autoIncrementId = 1L;

	public Address anAddress() {
		
		Address address = Address.builder()
				.id(autoIncrementId++)
				.city("Marseille")
				.country("France")
				.state("Bouches-du-Rhône")
				.line1("12 rue Robespierre")
				.phone("0654342178")
				.pinCode(342115)
				.build();

		log.info(address.toString());

		return address;
	}
}
