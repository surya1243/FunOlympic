package com.pofil.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
    List<Role> findAll();
}
