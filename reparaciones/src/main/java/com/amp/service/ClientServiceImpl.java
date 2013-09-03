package com.amp.service;

import java.util.ArrayList;
import java.util.List;

import com.amp.domain.Client;

public class ClientServiceImpl implements ClientService {

	List<Client> clients;

	public ClientServiceImpl() {
		clients = new ArrayList<Client>();

		clients.add(new Client(1, "Maxi"));
		clients.add(new Client(2, "Jose"));

	}

	@Override
	public List<Client> getClients() {
		return clients;
	}

	@Override
	public Client getClientById(int id) {
		return clients.get(id - 1);
	}
	
	@Override
	public void addClient(Client client) {
		int id = clients.get(clients.size() - 1).getId() + 1;
		client.setId(id); 
		clients.add(client);
	}

}
