package com.logique.urlencrypter.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logique.urlencrypter.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUserName(String userName);
	
}
