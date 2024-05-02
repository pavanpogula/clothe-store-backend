package com.clothestore.backend.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "admin")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Admin {
    @Id
    private String id;
    @Field("firstname")
    private String firstName;
    @Field("lastname")
    private String lastName;
    @Field("mail")
    private String mail;
    @Field("password")
    private String password;
    @Field("role")
    private String role;
}
