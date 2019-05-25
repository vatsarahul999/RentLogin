package com.rhl.rent.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhl.rent.db.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
