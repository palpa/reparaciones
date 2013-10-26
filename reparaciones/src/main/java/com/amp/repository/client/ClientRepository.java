package com.amp.repository.client;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.amp.entities.Client;


public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

	public List<Client> findAll();
	
	public void delete(Client client);
	
	public Page<Client> findAll(Pageable page);
	
	@Query("select c from Client c where lower(c.name) like ('%' || lower(?1) ||'%') OR lower(c.surName) like ('%'|| lower(?1) || '%') ") 
	public Page<Client> findByNameOrSurName(Pageable page, String name);

}

