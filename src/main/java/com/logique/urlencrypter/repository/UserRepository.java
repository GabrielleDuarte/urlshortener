package com.logique.urlencrypter.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.logique.urlencrypter.entity.User;


public interface UserRepository extends JpaRepository<User, String> {
	
}
