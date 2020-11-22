package com.logique.urlencrypter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logique.urlencrypter.entity.URL;
import com.logique.urlencrypter.entity.User;
import com.logique.urlencrypter.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "API USER")
@RestController
@RequestMapping(value = "/apiuser")
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Creates a new user")
	@PostMapping("/add")
	public String userAdd(Model model, @ModelAttribute User user) {
		model.addAttribute("user",new User());
		userService.addUser(user);
		return "registeruser";
	}
	
	@ApiOperation(value = "Returns the list of URLs created by ther user")
	@GetMapping("/listurlscreated/{id}")
	public  ResponseEntity<List<URL>> listURLsCreated(@PathVariable Long id){
		return new ResponseEntity<List<URL>>(userService.listCreatedURLs(id), HttpStatus.OK);
		
	}
}
