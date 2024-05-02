package com.clothestore.backend.admin.controller;

import com.clothestore.backend.admin.dto.AdminRequest;
import com.clothestore.backend.admin.dto.AdminResponse;
import com.clothestore.backend.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/loginAdmin")
    @ResponseStatus(HttpStatus.OK)
    public AdminResponse loginAdmin(@RequestBody AdminRequest adminRequest){
       return adminService.signIn(adminRequest);
    }

    @PostMapping("/getAdminDetailsById")
    @ResponseStatus(HttpStatus.OK)
    public AdminResponse fetchAdmin(@RequestBody AdminRequest adminRequest){
        return adminService.fetchAdminById(adminRequest);
    }

}
