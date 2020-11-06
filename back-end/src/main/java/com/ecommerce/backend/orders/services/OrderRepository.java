package com.ecommerce.backend.orders.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ecommerce.backend.orders.model.Order;

@Repository
@RepositoryRestResource(exported = false)
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}