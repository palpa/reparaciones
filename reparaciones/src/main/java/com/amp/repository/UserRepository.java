package com.amp.repository;

import java.util.List;

import com.apm.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

	public List<Users> findByUserName(String userName);
}
