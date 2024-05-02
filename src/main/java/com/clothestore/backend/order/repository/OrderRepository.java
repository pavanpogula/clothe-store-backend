package com.clothestore.backend.order.repository;

import com.clothestore.backend.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {
    List<Order> findByCustomerId(String customerId);
}
