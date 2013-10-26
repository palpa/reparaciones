package com.amp.controlers.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amp.domain.ClientDTO;
import com.amp.service.ClientService;

public class ApiClientController {
	
	@Autowired
	ClientService clientService;

	/**
	 * Controlador encargado de devolver un JSon con los datos del cliete
	 */
	@RequestMapping("api/client/{id}")
	@ResponseBody
	public ClientDTO getById(@PathVariable Integer id) {
		return clientService.getClientById(id);
	}
	
}
