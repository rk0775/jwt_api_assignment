package com.assignment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.configuration.JwtUtil;
import com.assignment.api.configuration.UserCustomConfigService;
import com.assignment.api.dao.UserRepository;
import com.assignment.api.model.UserModel;
import com.assignment.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	//user can register using this url
	@PostMapping("/signUp")
	public ResponseEntity<Object> saveNewUser(@RequestBody UserModel user) {
		ResponseEntity<Object> response= userService.signUpUser(user);
		return response;
		
	}
	
	
	//user can login using this url
	@PostMapping("/login")
	public ResponseEntity<Object> generateToken(@RequestBody UserModel user) throws Exception{
		ResponseEntity<Object> response= userService.loginUser(user);
		return response;
	}
	
	
	//this url access those user who can login success
	@PostMapping("/hello")
	public Object secureData(){
		return "Hello from GreenStitch";
	}
	
	
}
