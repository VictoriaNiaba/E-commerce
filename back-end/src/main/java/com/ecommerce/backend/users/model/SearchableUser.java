package com.ecommerce.backend.users.model;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
@Document(indexName = "user")
public class SearchableUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	private String firstName;

	private String lastName;

	private Integer age;

	private Integer role;

	private String photoUrl;

	private AuthenticationType authType;
}
