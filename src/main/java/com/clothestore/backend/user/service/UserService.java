package com.clothestore.backend.user.service;

import com.clothestore.backend.user.dto.UserRequest;
import com.clothestore.backend.user.dto.UserResponse;
import com.clothestore.backend.user.dto.UserSignUpRequest;
import com.clothestore.backend.user.model.User;
import com.clothestore.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse signIn(UserRequest userRequest){
    log.info(" signIn request USER : mail : {} and password : {} ",userRequest.getMail(),userRequest.getPassword());



       Optional<User> userOptional= userRepository.findByMailAndPassword(userRequest.getMail(),userRequest.getPassword());
        return getUserResponse(userOptional);
    }

    public UserResponse fetchUserById(UserRequest userRequest) {
        log.info(" fetchAdminById request  USER : id : {}",userRequest.getId());
        Optional<User> userOptional= userRepository.findById(userRequest.getId());
        return getUserResponse(userOptional);
    }

    private UserResponse getUserResponse(Optional<User> userOptional) {
        return userOptional.map(user -> UserResponse.builder()
                        .id(user.getId())
                        .mail(user.getMail())
                        .phone(user.getPhone())
                        .street(user.getStreet())
                        .city(user.getCity())
                        .country(user.getCountry())
                        .pin(user.getPin())
                        .state(user.getState())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .role(user.getRole())
                        .build())
                .orElse(UserResponse.builder().build());
    }

    public String signUpUser(UserSignUpRequest userSignUpRequest) {
        User user = User.builder()
                .mail(userSignUpRequest.getMail())
                .password(userSignUpRequest.getPassword())
                .phone(userSignUpRequest.getPhone())
                .street(userSignUpRequest.getStreet())
                .city(userSignUpRequest.getCity())
                .country(userSignUpRequest.getCountry())
                .pin(userSignUpRequest.getPin())
                .state(userSignUpRequest.getState())
                .firstName(userSignUpRequest.getFirstname())
                .lastName(userSignUpRequest.getLastname())
                .role("customer")
                .build();

try {

   userRepository.save(user);
    log.info("User {} saved successfully to Database", user);

}catch(DataIntegrityViolationException ex){
    log.error(" Error  signUpUser USER  : {}",ex.getMessage());
    return "{ \"msg\": \"409\" }";
        }
catch (Exception ex){
    log.error(" Error  signUpUser USER  : {}",ex.getMessage());
    return "{ \"msg\": \"500\" }";
}
        return "{ \"msg\": \"201\" }";
    }
}

