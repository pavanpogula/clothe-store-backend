package com.clothestore.backend.user.repository;

import com.clothestore.backend.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    @Query("{ 'mail' : ?0, 'password' : ?1 }")
    Optional<User> findByMailAndPassword(String mail, String password);
}
