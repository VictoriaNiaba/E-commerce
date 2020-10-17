package com.ecommerce.backend.orders.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.backend.orders.model.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {

}