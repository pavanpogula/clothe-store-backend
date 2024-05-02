package com.clothestore.backend.order.repository;


import com.clothestore.backend.order.model.OrderArray;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderArrayRepository extends MongoRepository<OrderArray,String> {
}
