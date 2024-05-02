package com.clothestore.backend.admin.repository;

import com.clothestore.backend.admin.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin,String> {
    @Query("{ 'mail' : ?0, 'password' : ?1 }")
    Optional<Admin> findByMailAndPassword(String mail, String password);
}
