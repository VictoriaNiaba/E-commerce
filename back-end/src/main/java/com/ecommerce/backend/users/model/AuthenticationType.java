package com.ecommerce.backend.users.model;

// TODO: Créer la même enumération en BDD
// TODO: Utiliser Lombok
public enum AuthenticationType {
	local("local"),
	social("social");

	private final String value;

	public String getValue() {
		return value;
	}

	AuthenticationType(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
