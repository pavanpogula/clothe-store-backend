package com.clothestore.backend.order.repository;

import com.clothestore.backend.order.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment,String> {
}
