package com.example.restservice.role;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.constants.ConstantApp.ERole;


public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
