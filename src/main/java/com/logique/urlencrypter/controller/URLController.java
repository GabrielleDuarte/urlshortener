package com.logique.urlencrypter.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logique.urlencrypter.entity.URL;
import com.logique.urlencrypter.entity.User;
import com.logique.urlencrypter.exceptions.UserException;
import com.logique.urlencrypter.repository.UserRepository;
import com.logique.urlencrypter.service.URLService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apiurl")
@Api(value = "API REST URL")
public class URLController {

	@Autowired
	private URLService urlService;

	@Autowired
	private UserRepository userRepository;
	
	@ApiOperation(value = "Creates a tiny version of a regular URL")
	@PostMapping("/shortenurl")
	public ResponseEntity<String> shortenURL(@PathVariable String url, @PathVariable Long userId) {
		return new ResponseEntity<>(urlService.shortenURL(url, userId), HttpStatus.OK);
	}

}
