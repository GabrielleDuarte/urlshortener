package com.logique.urlencrypter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logique.urlencrypter.entity.URL;
import com.logique.urlencrypter.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "API USER")
@RestController
@RequestMapping(value = "/apiuser")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ApiOperation(value = "Returns the list of URLs created by ther user")
	@GetMapping("/listurlscreated/{id}")
	public  ResponseEntity<List<URL>> listURLsCreated(@PathVariable String id){
		return new ResponseEntity<List<URL>>(userService.listCreatedURLs(id),HttpStatus.OK);
		
	}
}
