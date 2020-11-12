package com.logique.urlencrypter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logique.urlencrypter.entity.URL;

public interface URLRepository extends JpaRepository<URL, Long> {

}
