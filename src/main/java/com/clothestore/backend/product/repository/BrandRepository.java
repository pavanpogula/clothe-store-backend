package com.clothestore.backend.product.repository;

import com.clothestore.backend.product.model.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepository extends MongoRepository<Brand,String> {
}
