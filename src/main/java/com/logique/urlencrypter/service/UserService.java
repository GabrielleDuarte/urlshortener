package com.logique.urlencrypter.service;

import java.util.List;

import com.logique.urlencrypter.entity.URL;

public interface UserService {
	
	public List<URL> listCreatedURLs(String id);
	

}


