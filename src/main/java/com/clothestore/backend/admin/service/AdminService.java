package com.clothestore.backend.admin.service;

import com.clothestore.backend.admin.dto.AdminRequest;
import com.clothestore.backend.admin.dto.AdminResponse;
import com.clothestore.backend.admin.model.Admin;
import com.clothestore.backend.admin.repository.AdminRepository;
import com.clothestore.backend.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminResponse signIn(AdminRequest adminRequest){
    log.info(" signIn request ADMIN: mail : {} and password : {} ",adminRequest.getMail(),adminRequest.getPassword());
       Optional<Admin> adminOptional= adminRepository.findByMailAndPassword(adminRequest.getMail(),adminRequest.getPassword());
        return getAdminResponse(adminOptional);
    }

    public AdminResponse fetchAdminById(AdminRequest adminRequest) {
        log.info(" fetchAdminById request  ADMIN: id : {}",adminRequest.getId());
        Optional<Admin> adminOptional = adminRepository.findById(adminRequest.getId());
        return getAdminResponse(adminOptional);

    }

    private AdminResponse getAdminResponse(Optional<Admin> adminOptional){
   return adminOptional.map(admin -> AdminResponse.builder()
                        .id(admin.getId())
                        .role(admin.getRole())
                        .firstName(admin.getFirstName())
                        .mail(admin.getMail())
                        .lastName(admin.getLastName())
                        .build())
                .orElse(AdminResponse.builder().build());
    }
}
