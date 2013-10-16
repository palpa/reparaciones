package com.amp.service;

import org.springframework.data.domain.PageRequest;

import com.amp.commons.DomainClientPage;
import com.amp.domain.ClientDTO;

public interface ClientService {

	public ClientDTO getClientById(int id);
	
	public void addClient(ClientDTO client);
	
	public DomainClientPage getPageClients(int numPage);
}
