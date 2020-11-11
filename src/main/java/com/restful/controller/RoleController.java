package com.restful.controller;

import com.restful.data.models.Role;
import com.restful.data.response.WebResponse;
import com.restful.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<?> getAllRole() {
        List<Role> roles = roleService.getAllRole();
        return ResponseEntity.ok(new WebResponse<>(LocalDateTime.now().toString(), "success", roles));
    }
}
