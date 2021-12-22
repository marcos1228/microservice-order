package com.order.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.domain.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	Page<Order> findByDescriptionContainingIgnoreCase(String description,Pageable pageable);
}
