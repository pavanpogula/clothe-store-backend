package com.clothestore.backend.product.repository;

import com.clothestore.backend.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
