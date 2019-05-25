package com.rhl.rent.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhl.rent.db.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public Role findByName(String name);
	
}
