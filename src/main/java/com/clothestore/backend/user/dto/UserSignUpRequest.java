package com.clothestore.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignUpRequest {

    private String mail;
    private String password;
    private String phone;
    private String street;
    private String city;
    private String country;
    private String pin;
    private String state;
    private String firstname;
    private String lastname;
    private String role;
}
