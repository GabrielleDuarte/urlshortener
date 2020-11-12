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
import com.logique.urlencrypter.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService , UserService {

    @Autowired
    UserRepository userRepository;

    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }


	@Override
	public List<URL> listCreatedURLs(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
