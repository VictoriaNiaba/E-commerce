package com.ecommerce.backend.products.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.backend.products.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}