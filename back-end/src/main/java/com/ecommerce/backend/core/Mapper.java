package com.ecommerce.backend.core;

public interface Mapper<T, D, S> {

	public D toDto(T domain);

	public T toDomain(D dto);

	public S toSearch(T domain);
}
