package com.assignment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment.api.configuration.JwtUtil;
import com.assignment.api.configuration.UserCustomConfigService;
import com.assignment.api.dao.UserRepository;
import com.assignment.api.model.UserModel;

@Service
public class UserService {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserCustomConfigService userCustomConfigService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository  userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	//this function helps to save user details
	public ResponseEntity<Object> signUpUser(UserModel user) {
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRole("ROLE_NORMAL");
			userRepository.save(user);
			return new ResponseEntity<Object> ("user save successfully.",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	//this function helps to login the user and generate the JWT token
	public ResponseEntity<Object> loginUser(UserModel user) {
		// TODO Auto-generated method stub
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail() , user.getPassword()));
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.ok("{\"message\" : \"Invalid email or password..\",\"status\":1}");
		}
		//generate the token
		UserDetails userDetails= this.userCustomConfigService.loadUserByUsername(user.getEmail());
		String token=this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok("{ \"Token\" : \""+token+"\", \"status\":0, \"message\": \"user can successfully login.\"}");
	}
		
}
