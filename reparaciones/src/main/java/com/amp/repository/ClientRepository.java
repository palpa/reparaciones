package com.amp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.apm.entities.Client;


public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

	public List<Client> findAll();
	
	public void delete(Client client);
	
	public Page<Client> findAll(Pageable page);

}

