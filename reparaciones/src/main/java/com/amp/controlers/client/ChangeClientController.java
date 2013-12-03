package com.amp.controlers.client;

import org.h2.util.New;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amp.commons.helperscontrolers.ClientControlerHelper;
import com.amp.service.client.ClientService;

@Controller
public class ChangeClientController {
	
	private ClientControlerHelper helper = new ClientControlerHelper();
	private ClientService clientService;

	@RequestMapping(value = "clients/add/{id}")
	public String changeClient(Model model, @PathVariable int id){
		
		this.helper.getModelChangeAddClient(model,id, clientService);	
		
		return "addClient";
	}
	
}
