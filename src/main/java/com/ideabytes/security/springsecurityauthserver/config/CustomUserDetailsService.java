package com.ideabytes.security.springsecurityauthserver.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ideabytes.security.springsecurityauthserver.models.SignUp;
import com.ideabytes.security.springsecurityauthserver.repo.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepository;
	


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		// TODO Auto-generated method stub
		SignUp user = userRepository.findByEmail(email);
		
	
		if(user == null) {
			
		      throw new UsernameNotFoundException("User not found");
		    }
		 List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		    return new User(user.getEmail(), user.getPassword(), authorities);
		
		
	}

}
