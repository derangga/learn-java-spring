package com.restful.service.impl;

import com.restful.data.models.User;
import com.restful.data.response.UserByTokenResponse;
import com.restful.repository.UserRepository;
import com.restful.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserByTokenResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
        return new UserByTokenResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
