package com.ecommerce.backend.users.services;

import org.mapstruct.Mapper;

import com.ecommerce.backend.users.api.UserDto;
import com.ecommerce.backend.users.model.SearchableUser;
import com.ecommerce.backend.users.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	public UserDto toDto(User domain);
	
	public SearchableUser toSearch(User domain);
}