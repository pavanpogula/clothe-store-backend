package com.clothestore.backend.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String mail;
    private String role;
}
