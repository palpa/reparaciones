package com.amp.service;

import java.util.ArrayList;
import java.util.List;

import com.amp.domain.Client;

public class ClientService {

	List<Client> clients;

	public ClientService() {
		clients = new ArrayList<Client>();

		clients.add(new Client(1, "Maxi"));
		clients.add(new Client(2, "Jose"));

	}

	public Client getClientById(int id) {
		return clients.get(id - 1);
	}

}
