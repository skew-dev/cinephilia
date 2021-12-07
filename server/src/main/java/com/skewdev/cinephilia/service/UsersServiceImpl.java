package com.skewdev.cinephilia.service;

import com.skewdev.cinephilia.entity.Role;
import com.skewdev.cinephilia.entity.User;
import com.skewdev.cinephilia.repository.RoleRepository;
import com.skewdev.cinephilia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService, UserDetailsService {

	@Autowired
	private UserRepository usersRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.getRoles().add(roleRepository.findByName("ROLE_USER"));
		return usersRepository.save(user);
	}

	@Override
	public Role saveRole(Role rol) {
		return roleRepository.save(rol);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = usersRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		return usersRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return usersRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
}