package com.amp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.apm.entities.Client;


public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

	public List<Client> findAll();

}

