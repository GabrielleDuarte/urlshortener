package com.logique.urlencrypter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.logique.urlencrypter.entity.MyUserDetails;
import com.logique.urlencrypter.entity.URL;
import com.logique.urlencrypter.entity.User;
import com.logique.urlencrypter.exceptions.UserException;
import com.logique.urlencrypter.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService, UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

		return user.map(MyUserDetails::new).get();
	}

	@Override
	public List<URL> listCreatedURLs(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserException("User not registred"));
		return user.getCreatedURLs();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}
}
