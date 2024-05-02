package com.clothestore.backend.user.controller;


import com.clothestore.backend.user.dto.UserRequest;
import com.clothestore.backend.user.dto.UserResponse;
import com.clothestore.backend.user.dto.UserSignUpRequest;
import com.clothestore.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/loginCustomer")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse loginUser(@RequestBody UserRequest userRequest){
       return userService.signIn(userRequest);
    }

    @PostMapping("/getCustomerDetailsById")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse fetchUser(@RequestBody UserRequest userRequest){
        return userService.fetchUserById(userRequest);
    }

    @PostMapping("/addCustomer")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> signUpUser(@RequestBody UserSignUpRequest userSignUpRequest){
        String responseJson = userService.signUpUser(userSignUpRequest);
        return ResponseEntity.status(HttpStatus.OK).body(responseJson);
    }

}
