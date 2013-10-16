package com.amp.controlers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amp.commons.ErrorsManager;
import com.amp.domain.ClientDTO;
import com.amp.domain.User;
import com.amp.service.ClientService;
import com.amp.service.UserService;
import com.apm.entities.Client;

@Controller
public class ClientController {

	protected final Log logger = LogFactory.getLog(getClass());

	ClientService clientService;
	UserService userService;

	@Autowired
	public ClientController(ClientService clientService, UserService userService) {
		this.clientService = clientService;
		this.userService = userService;
	}

	@RequestMapping("clients/")
	public String loadClientsPage(Model m, HttpServletRequest request) {

		// Creo el usuario admin/admin
		User user = new User();
		user.setName("admin");
		user.setPassword("admin");

		// Guardo el usuario
		userService.savaUser(user);

		// Pruebo recuperarlo
		User othetUser = userService.getUserByUserName(user.getName());

		return "clients";
	}

	@RequestMapping(value = "clients/add", method = RequestMethod.GET)
	public String addClientPage(Model m) {
		m.addAttribute("error", "");
		//m.addAttribute("client", new Client());
		return "addClient";
	}

	@RequestMapping(value = "clients/add", method = RequestMethod.POST)
	public String addClientForm(@Valid @ModelAttribute ClientDTO client,
			BindingResult result, Model m) {

		ErrorsManager errorManager = new ErrorsManager(result);
		m.addAttribute("error", errorManager.getErrorMessage());
		
		if (!errorManager.existError()) {
			clientService.addClient(client);
		}

		//m.addAttribute("client", client);

		return "addClient";
	}

	@RequestMapping("api/client/{id}")
	@ResponseBody
	public ClientDTO getById(@PathVariable Integer id) {
		return clientService.getClientById(id);
	}

}
