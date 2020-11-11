package com.restful.data.response;

import com.restful.data.models.Role;

import java.util.List;
import java.util.Set;

public class RegisterResponse {
	private String username;
	private String email;
	private Set<Role> roles;

	public RegisterResponse(String username, String email, Set<Role> roles) {
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
