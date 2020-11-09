package com.logique.urlencrypter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logique.urlencrypter.entity.URL;
import com.logique.urlencrypter.entity.User;
import com.logique.urlencrypter.exceptions.UserException;
import com.logique.urlencrypter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<URL> listCreatedURLs(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserException("This user is not registered"));
		return user.getCreatedURLs();
	}

	/*
	 * /*@Override public void updateLastLocation(Location newLastLocation, Long id)
	 * { Survivor survivor = survivorDAO.findById(id) .orElseThrow(() -> new
	 * SurvivorException("This survivor is not registered"));
	 * survivor.setLastLocation(newLastLocation); survivorDAO.save(survivor);
	 * 
	 * }
	 */
}
