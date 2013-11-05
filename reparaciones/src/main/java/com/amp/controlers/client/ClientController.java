package com.amp.controlers.client;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amp.commons.errors.ErrorsManager;
import com.amp.commons.pages.DomainClientPage;
import com.amp.domain.ClientDTO;
import com.amp.domain.User;
import com.amp.service.UserService;
import com.amp.service.client.ClientService;

@Controller
public class ClientController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	ClientService clientService;

	/**
	 * Controlador encargado de agregar de agregar un cliente
	 */
	@RequestMapping(value = "clients/add", method = RequestMethod.POST)
	public String addClientForm(@Valid @ModelAttribute ClientDTO client,
			BindingResult result, Model m) {

		ErrorsManager errorManager = new ErrorsManager(result);
		m.addAttribute("error", errorManager.getErrorMessage());

		if (!errorManager.existError()) {
			clientService.addClient(client);
		}
		return "addClient";
	}

	/**
	 * Controlador encargado retornar la vista cuando se ingresa a la seccion de
	 * crear un cliente
	 */
	@RequestMapping(value = "clients/add", method = RequestMethod.GET)
	public String addClientPage(Model m) {
		m.addAttribute("error", "");
		return "addClient";
	}

	/**
	 * Controlador que retorna una pagina del cliente
	 */
	@RequestMapping("clients/{page}")
	public String loadClients(Model model, @PathVariable int page,
			@RequestParam(value = "search", required = false) String search) {

		getClientesResult(model, page, search);

		return "clients";
	}
	
	@RequestMapping(value="/clients/remove/", method = RequestMethod.POST)
	@Transactional
	public String removeClient(Model model, @RequestParam(value = "clientId") int id){
		
		System.out.println("El id del cliente a eliminar es: " + Integer.toString(id));
		
		clientService.deleteById(id);
		
		getClientesResult(model, 1, "");		
		return "clients";
	}

	/**
	 * Controlador que reorla la pagina inicial del cliente
	 */
	@RequestMapping("clients/")
	public String loadClientsPage(Model model) {

		getClientesResult(model, 1, "");

		return "clients";
	}

	/**
	 * Metodo encargado de retornar una pagina del cliente para la busqueda y
	 * seleccion normal
	 */
	private void getClientesResult(Model model, int page, String search) {
		DomainClientPage myPageClient;
		if ((search == null) || search.isEmpty()) {
			myPageClient = clientService.getPageClients(page);
			model.addAttribute("search", "");
		} else {
			myPageClient = clientService.getPageClientByNameOrSurname(page,
					search);
			model.addAttribute("search", search);
		}

		model.addAttribute("clients", myPageClient.getPageElements());
		model.addAttribute("pages", myPageClient.getPageNumbers());
	}
}
