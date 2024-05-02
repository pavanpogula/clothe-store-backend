package com.clothestore.backend.product.repository;

import com.clothestore.backend.product.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image,String> {
}
