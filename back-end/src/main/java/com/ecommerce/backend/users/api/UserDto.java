package com.ecommerce.backend.users.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder 
@NoArgsConstructor @AllArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;
    
    private String firstName;
    
    private String lastName;
}
