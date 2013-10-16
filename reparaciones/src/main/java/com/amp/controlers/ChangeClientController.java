package com.amp.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amp.commons.DomainClientPage;
import com.amp.domain.ClientDTO;
import com.amp.service.ClientService;


@Controller
public class ChangeClientController {	
	
	@Autowired
	ClientService clientServices;
	
	@RequestMapping("clients/changeClients/{page}")
	public String loadClients(Model model, @PathVariable int page){
		
		List<Integer> lista = new ArrayList<Integer>(); 
		lista.add(1);
		lista.add(2);
		lista.add(3);
		
		List<ClientDTO> myClients = clientServices.getPageClients(page).getPageElements();
		
		DomainClientPage myPage = clientServices.getPageClients(page);		
		//List<ClientDTO> myClients = myPage.getPageElements();
		
		model.addAttribute("clients", myClients);
		model.addAttribute("pages", myPage.getPageNumbers());
		
		return "clients";
	}

}
