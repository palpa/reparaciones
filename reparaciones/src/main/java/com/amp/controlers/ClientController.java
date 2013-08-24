package com.amp.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amp.domain.Client;
import com.amp.service.ClientService;

@Controller
public class ClientController {

	ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping("clients")
	public String loadClientsPage(Model m) {

		m.addAttribute("clients", clientService.getClients());

		return "clients";
	}

	@RequestMapping("api/client/{id}")
	@ResponseBody
	public Client getById(@PathVariable Integer id) {
		return clientService.getClientById(id);
	}

}
