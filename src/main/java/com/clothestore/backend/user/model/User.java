package com.clothestore.backend.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    @Field("mail")
    private String mail;
    @Field("password")
    private String password;
    @Field("phone")
    private String phone;
    @Field("street")
    private String street;
    @Field("city")
    private String city;
    @Field("country")
    private String country;
    @Field("pin")
    private String pin;
    @Field("state")
    private String state;
    @Field("firstname")
    private String firstName;
    @Field("lastname")
    private String lastName;
    @Field("role")
    private String role;
}
