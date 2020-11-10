package com.restful.service;
;
import com.restful.data.response.UserByTokenResponse;

public interface UserService {
    UserByTokenResponse getUserByUsername(String username);
}
