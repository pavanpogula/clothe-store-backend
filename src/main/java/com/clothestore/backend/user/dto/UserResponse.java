package com.clothestore.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String mail;
    private String phone;
    private String street;
    private String city;
    private String country;
    private String pin;
    private String state;
    private String firstName;
    private String lastName;
    private String role;

}