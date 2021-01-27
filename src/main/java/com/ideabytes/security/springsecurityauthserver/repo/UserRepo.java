package com.ideabytes.security.springsecurityauthserver.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ideabytes.security.springsecurityauthserver.models.SignUp;


public interface UserRepo extends MongoRepository<SignUp, String> {
	
	SignUp findByEmail(String email);

}
