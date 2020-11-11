package com.restful.service;

import com.restful.data.request.LoginRequest;
import com.restful.data.request.RegisterRequest;
import com.restful.data.response.LoginResponse;
import com.restful.data.response.RegisterResponse;
import com.restful.exception.UserExistsException;

public interface AuthService {
    LoginResponse userLogin(LoginRequest request);
    RegisterResponse userRegister(RegisterRequest request) throws UserExistsException;
}
