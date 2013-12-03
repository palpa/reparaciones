package com.amp.commons.helperscontrolers;

import org.springframework.ui.Model;

import com.amp.domain.ClientDTO;
import com.amp.service.client.ClientService;

public class ClientControlerHelper {

	public void getModelChangeAddClient(Model model, int id, ClientService service){
		
		if (id < 0){			
			model.addAttribute("client",service.getClientById(id));
		}
		else{
			model.addAttribute("client", new ClientDTO());
		}		
		model.addAttribute("error","");
	}
	
}
