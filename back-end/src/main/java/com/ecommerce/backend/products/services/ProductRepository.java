package com.ecommerce.backend.products.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ecommerce.backend.products.model.Product;

@Repository
@RepositoryRestResource(exported = false)
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}