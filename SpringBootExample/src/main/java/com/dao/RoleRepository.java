package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
	
}
