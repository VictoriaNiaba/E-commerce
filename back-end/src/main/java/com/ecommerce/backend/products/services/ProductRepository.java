package com.ecommerce.backend.products.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.backend.products.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

}