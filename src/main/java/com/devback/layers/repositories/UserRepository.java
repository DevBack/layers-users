package com.devback.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devback.layers.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
