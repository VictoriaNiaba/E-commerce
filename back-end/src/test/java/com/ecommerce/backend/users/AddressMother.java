package com.ecommerce.backend.users;

import com.ecommerce.backend.users.model.Address;
import com.ecommerce.backend.users.model.Address.AddressBuilder;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class AddressMother {
	
	private long autoIncrementId = 1L;

	public AddressBuilder anAddress() {
		
		AddressBuilder addressBuilder = Address.builder()
				.id(autoIncrementId++)
				.city("Marseille")
				.country("France")
				.state("Bouches-du-Rhône")
				.line1("12 rue Robespierre")
				.phone("0654342178")
				.pinCode(342115);

		log.info(addressBuilder.toString());

		return addressBuilder;
	}
}
