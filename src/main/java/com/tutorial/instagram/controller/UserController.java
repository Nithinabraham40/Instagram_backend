package com.tutorial.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.instagram.dao.SignUpOutputDao;
import com.tutorial.instagram.dao.SigninInputDao;
import com.tutorial.instagram.dao.SigninOutputDao;
import com.tutorial.instagram.dao.SignupInputDao;
import com.tutorial.instagram.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	
	public SignUpOutputDao signUp(@Valid @RequestBody SignupInputDao input) {
		
		
		
		return userService.signUp(input);
		
		
	}
	
	@PostMapping("/signin")
	public SigninOutputDao signIn(@Valid @RequestBody SigninInputDao input) {
		
		return userService.signIn(input);
	}
	
	@PutMapping("/update/{token}")
	
	public ResponseEntity<String>updateUserDetails(@PathVariable("token") String token, @RequestBody SignupInputDao input){
		
		
		return userService.updateUserDetails(token,input);
	}
}
