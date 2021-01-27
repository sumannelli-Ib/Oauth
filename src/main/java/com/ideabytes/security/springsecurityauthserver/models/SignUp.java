package com.ideabytes.security.springsecurityauthserver.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SignUp {
	
	@Id
	public ObjectId _id;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	private String email;
	private String password;
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	

	
	public void setPassword(String password) {
		
		this.password = password;
	}
	

}
