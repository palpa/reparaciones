package com.amp.service;

import com.amp.commons.DomainClientPage;
import com.amp.domain.ClientDTO;

public interface ClientService {

	public ClientDTO getClientById(int id);
	
	public void addClient(ClientDTO client);
	
	public DomainClientPage getPageClients(int numPage);
	
	public DomainClientPage getPageClientByNameOrSurname(int numPage, String nameOrSurname);
	
	public void delete(ClientDTO aClient);
}
