package com.ecommerce.backend.users.services;

import org.apache.commons.lang3.NotImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.core.Mapper;
import com.ecommerce.backend.users.api.UserDto;
import com.ecommerce.backend.users.model.SearchableUser;
import com.ecommerce.backend.users.model.User;

@Service
public class UserMapper implements Mapper<User, UserDto, SearchableUser> {

	private @Autowired ModelMapper modelMapper;

	@Override
	public UserDto toDto(User domain) {
		return modelMapper.map(domain, UserDto.class);
	}

	@Override
	public User toDomain(UserDto dto) {
		throw new NotImplementedException("Not implemented yet.");
	}
	
	@Override
	public SearchableUser toSearch(User domain) {
		return modelMapper.map(domain, SearchableUser.class);
	}
}