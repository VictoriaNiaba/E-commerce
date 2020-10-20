package com.ecommerce.backend.core;

public interface Mapper<T, D> {

	public D toDto(T domain);

	public T toDomain(D dto);
}
