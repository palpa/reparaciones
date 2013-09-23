package com.amp.service;

import java.util.List;

import com.amp.domain.Client;

public interface ClientService {

	public List<Client> getClients();

	public Client getClientById(int id);
	
	public void addClient(Client client);

}
