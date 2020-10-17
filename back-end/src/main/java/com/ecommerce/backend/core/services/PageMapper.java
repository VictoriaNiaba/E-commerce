package com.ecommerce.backend.core.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PageMapper<T> {
	
	public CustomPage<T> toDomain(Page<T> page) {
		return CustomPage.<T>builder()
				.content(page.getContent())
				.totalCount(page.getTotalElements())
				.build();
	}
}
	