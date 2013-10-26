package com.amp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amp.domain.User;
import com.amp.entities.Users;
import com.amp.repository.UserRepository;

@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository repository;

	public User getUserByUserName(String userName) {
		
		 Users aUserRepository = (Users) repository.findByUserName(userName).get(0);		 
		 User aUserDomain = new User();
		 
		 aUserDomain.setName(aUserRepository.getUser());
		 aUserDomain.setPassword(aUserRepository.getPassword());		 
		
		return aUserDomain;
	}

	public void savaUser(User user) {
		
		Users aNewUser = new Users();		
		aNewUser.setPassword(user.getPassword());
		aNewUser.setUser(user.getName());		
		repository.save(aNewUser);		
	}

	

}
