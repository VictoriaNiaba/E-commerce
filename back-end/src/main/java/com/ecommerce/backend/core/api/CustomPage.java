package com.ecommerce.backend.core.api;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CustomPage<T> {
	private long totalCount;
	private List<T> content;
}
