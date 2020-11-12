package com.logique.urlencrypter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logique.urlencrypter.entity.URL;
import com.logique.urlencrypter.entity.User;
import com.logique.urlencrypter.exceptions.UserException;
import com.logique.urlencrypter.repository.URLRepository;
import com.logique.urlencrypter.repository.UserRepository;

@Service
public class URLServiceImpl implements URLService {

	private URLRepository urlRepository;
	
	@Autowired
	private UserRepository userRepository;

	public URLServiceImpl(URLRepository urlRepository) {
		super();
		this.urlRepository = urlRepository;
	}


	@Override
	public String shortenURL(String url, Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not registred"));
		URL newUrl = new URL(url);
		newUrl.generateShorterURL();

		save(newUrl);

		user.getCreatedURLs().add(newUrl);
		return newUrl.getShorter();
	}

	@Override
	public void save(URL url) {
		urlRepository.save(url);
	}





}
