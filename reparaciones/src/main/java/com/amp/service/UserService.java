package com.amp.service;

import com.amp.domain.User;

public interface UserService {

	public User getUserByUserName(String userName);
	
	public void savaUser(User user);	
}
