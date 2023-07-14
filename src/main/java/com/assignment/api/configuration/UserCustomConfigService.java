package com.assignment.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.assignment.api.dao.UserRepository;
import com.assignment.api.model.UserModel;



@Service
public class UserCustomConfigService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		try {
			UserModel user = userRepository.findByEmail(email);
			if (user == null) {
				throw new UsernameNotFoundException("Invalid User name or passeword !!");
			} else {
				return new UserCustomConfig(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return null;
	}
}
