package com.amp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amp.domain.Client;
import com.amp.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepostitory;

	public List<Client> getClients() {
		return clientRepostitory.findAll();
	}

	public Client getClientById(int id) {
		return clientRepostitory.findOne(id);
	}

	public void addClient(Client client) {
		clientRepostitory.save(client);
	}
}
