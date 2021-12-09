package com.skewdev.cinephilia.service;


import com.skewdev.cinephilia.entity.Role;
import com.skewdev.cinephilia.entity.User;

import java.util.List;

public interface UsersService {

	User saveUser(User usuario);

	Role saveRole(Role rol);

	void addRoleToUser(String email, String role);

	User getUser(String usuario);

	List<User> getUsers();
}