package com.amp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amp.domain.Client;
import com.amp.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	// List<Client> clients;

	private ClientRepository clientRepostitory;

	@Autowired
	public ClientServiceImpl(ClientRepository clientRepostitory) {
		this.clientRepostitory = clientRepostitory;

		// clients = new ArrayList<Client>();
		// clients.add(new Client(1, "Maxi"));
		// clients.add(new Client(2, "Jose"));

	}

	public List<Client> getClients() {
		// return clients;
		return clientRepostitory.findAll();
	}

	public Client getClientById(int id) {
		// return clients.get(id - 1);
		return clientRepostitory.findOne(id);
	}

	public void addClient(Client client) {
		// int id = clients.get(clients.size() - 1).getId() + 1;
		// client.setId(id);
		// clients.add(client);
		clientRepostitory.save(client);
	}

}
