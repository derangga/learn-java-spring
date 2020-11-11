package com.restful.controller;

import com.restful.data.response.UserByTokenResponse;
import com.restful.data.response.WebResponse;
import com.restful.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> userAccess(Principal principal) {
        String username = principal.getName();
        UserByTokenResponse userResponse = userService.getUserByUsername(username);
        return ResponseEntity.ok(new WebResponse<>(LocalDateTime.now().toString(), "success", userResponse));
    }
}
