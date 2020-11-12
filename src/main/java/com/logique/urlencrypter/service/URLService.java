package com.logique.urlencrypter.service;

import com.logique.urlencrypter.entity.URL;

public interface URLService {
	
	public void save(URL url);
	
	public String shortenURL (String url, Long userId);
	
}
