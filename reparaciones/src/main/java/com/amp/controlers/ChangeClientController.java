package com.amp.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amp.commons.DomainClientPage;
import com.amp.service.ClientService;


@Controller
public class ChangeClientController {	
	
	@Autowired
	ClientService clientServices;
	
	@RequestMapping("clients/changeClients/{page}")
	public String loadClients(Model model, @PathVariable int page, @RequestParam(value="search", required=false) String search){
		
		DomainClientPage myPageClient;
		if((search == null) || search.isEmpty()){			
			myPageClient = clientServices.getPageClients(page);
			model.addAttribute("search", "");
		}
		else{
			myPageClient = clientServices.getPageClientByNameOrSurname(page,search);
			model.addAttribute("search", search);
		}		
		
		model.addAttribute("clients", myPageClient.getPageElements());
		model.addAttribute("pages", myPageClient.getPageNumbers());
		return "clients";
	}
	
}
