package com.amp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.amp.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}

