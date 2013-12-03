package com.amp.repository.client;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.amp.entities.Client;


public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

	public List<Client> findAll();
	
	@Transactional
	public Client save(Client client);
	
	public Client findById(int id);
	
	@Transactional
	public void delete(Client client);
	
	@Transactional
	//public Client save(Client client);
	
	public Page<Client> findAll(Pageable page);
	
	//@Modifying
	//public Client update(Client updated);
	//@Transactional
	 //c.surName = ?2, c.adress = ?3, c.phone = ?4, c.cel = ?5, c.email = ?6) where c.id = ?7"
	//@Transactional
	//@Modifying
	//@Query("update Client c set c.name = ?1, c.surName = ?2, c.adress = ?3, c.phone = ?4,  c.cel = ?5,c.email = ?6 where c.id = ?7")
	//public void update(String name, String surName, String adress, String phone, String cel, String email, int id);
	
	@Query("select c from Client c where lower(c.name) like ('%' || lower(?1) ||'%') OR lower(c.surName) like ('%'|| lower(?1) || '%') ") 
	public Page<Client> findByNameOrSurName(Pageable page, String name);

}

