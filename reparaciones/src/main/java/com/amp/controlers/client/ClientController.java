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

import com.amp.commons.errors.ErrorsManager;
import com.amp.commons.helperscontrolers.ClientControlerHelper;
import com.amp.commons.pages.DomainClientPage;
import com.amp.domain.ClientDTO;
import com.amp.service.client.ClientService;

@Controller
public class ClientController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	ClientService clientService;
	ClientControlerHelper clientHelper = new ClientControlerHelper();

	/**
	 * Controlador encargado de agregar un cliente
	 */
	@RequestMapping(value = "clients/add", method = RequestMethod.POST)
	public String addClientForm(@Valid @ModelAttribute ClientDTO client,
			BindingResult result, Model model) {

		ErrorsManager errorManager = new ErrorsManager(result);
		model.addAttribute("error", errorManager.getErrorMessage());

		if (!errorManager.existError()) {
			clientService.addClient(client);
		}
		
		this.clientHelper.getModelChangeAddClient(model, 0, clientService);
		return "addClient";
	}

	/**
	 * Controlador encargado retornar la vista cuando se ingresa a la seccion de
	 * crear un cliente
	 */
	@RequestMapping(value = "clients/add", method = RequestMethod.GET)
	public String addClientPage(Model model, @RequestParam(value = "search", required = false) String idClient) {
		
		//this.getAddClientPage(model, idClient);
		
		/*ClientDTO myClient = new ClientDTO();
		myClient.setName("Cliente de prueba");
		myClient.setSurName("Apellido de prueba");
		myClient.setAdress("Direccion de prueba");
		myClient.setPhone("telefono de prueba");
		myClient.setCel("celular de prueba");
		myClient.setDni("Dni de prueba");
		myClient.setEmail("Email de prueba");
		
		model.addAttribute("client", myClient);
		
		model.addAttribute("error", "");*/
		this.clientHelper.getModelChangeAddClient(model, 0, clientService);
		return "addClient";
	}

	private void getAddClientPage(Model model, String idClient) {
		
		if(idClient.isEmpty() || idClient == null){
			//model.addAllAttributes(arg0)
		}
		else{
			
		}
		
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
	
	@RequestMapping("clients/update")
	public String updateClient(@Valid @ModelAttribute ClientDTO client,
			BindingResult result, Model model) {		
		
		clientService.updateCliente(client);
		
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
