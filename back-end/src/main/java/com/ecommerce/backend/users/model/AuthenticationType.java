package com.ecommerce.backend.users.model;

// TODO: Créer la même enumération en BDD
// TODO: Utiliser Lombok
public enum AuthenticationType {
	LOCAL("local"),
	SOCIAL("social");

	private final String value;

	public String getValue() {
		return value;
	}

	AuthenticationType(String value) {
		this.value = value;
	}
}
