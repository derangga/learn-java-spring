package com.restful.controller;

import com.restful.data.request.LoginRequest;
import com.restful.data.request.RegisterRequest;
import com.restful.data.response.LoginResponse;
import com.restful.data.response.MessageResponse;
import com.restful.exception.UserExistsException;
import com.restful.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.userLogin(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest signUpRequest) throws UserExistsException {
        MessageResponse response = authService.userRegister(signUpRequest);
        return ResponseEntity.ok(response);
    }
}
