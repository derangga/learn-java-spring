package com.restful.controller;

import com.restful.data.request.LoginRequest;
import com.restful.data.request.RegisterRequest;
import com.restful.data.response.LoginResponse;
import com.restful.data.response.RegisterResponse;
import com.restful.data.response.WebResponse;
import com.restful.exception.UserExistsException;
import com.restful.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

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
        return ResponseEntity.ok(new WebResponse<>(LocalDateTime.now().toString(), "success", response));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest signUpRequest) throws UserExistsException {
        RegisterResponse response = authService.userRegister(signUpRequest);
        return ResponseEntity.ok(new WebResponse<>(LocalDateTime.now().toString(), "success", response));
    }
}
