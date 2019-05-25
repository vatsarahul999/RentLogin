package com.rhl.rent.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rhl.rent.DTO.UserDTO;
import com.rhl.rent.db.model.Role;
import com.rhl.rent.db.model.User;
import com.rhl.rent.db.repo.RoleRepository;
import com.rhl.rent.db.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void createUser(UserDTO userDTO) {
		User user = new User();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> role = new HashSet<>();
		role.add(roleRepository.findByName(userDTO.getRole()));
		user.setRoles(role);
		userRepository.save(user);
		log.info("New user {} has been created ", userDTO);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}