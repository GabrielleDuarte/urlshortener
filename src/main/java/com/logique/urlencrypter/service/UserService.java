package com.logique.urlencrypter.service;

import java.util.List;

import com.logique.urlencrypter.entity.URL;
import com.logique.urlencrypter.entity.User;

public interface UserService {
	
	public List<URL> listCreatedURLs(Long id);
	
	public void addUser(User user);
}


