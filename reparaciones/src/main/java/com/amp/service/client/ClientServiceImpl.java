package com.amp.service.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amp.commons.pages.DomainClientPage;
import com.amp.domain.ClientDTO;
import com.amp.entities.Client;
import com.amp.repository.client.ClientRepository;

/**
 * @author juan.eduardo.mendoza
 *
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepostitory;
	
	
	public void addClient(ClientDTO client) {
		clientRepostitory.save(convertClientDTOToRepository(client));
	}	

	public void delete(ClientDTO aClient) {

		clientRepostitory.delete(this.convertClientDTOToRepository(aClient));

	}
	
	public ClientDTO getClientById(int id) {
		return convertClientRepositoryToDto(clientRepostitory.findOne(id));
	}

	public DomainClientPage getPageClientByNameOrSurname(int pageNumber, String nameOrSurname) {
		
		//TODO: Hay que teomar el numero de elementos de paginas de un archivo de propiedades
		PageRequest myPageRequest = new PageRequest(pageNumber - 1,5);
		DomainClientPage myDomainPage = getDomainClientPageByNameOrSurName(nameOrSurname, myPageRequest);
		
		return myDomainPage;
		
	}
	
	public DomainClientPage getPageClients(int numPage){
		
		//TODO: Hay que tomar el numero de paginas de un archivo de propiedades
		PageRequest myPageRequest = new PageRequest(numPage - 1,5);				
		DomainClientPage myDomainPage = getDomainClientPage(myPageRequest);		
		return myDomainPage;
	}

	private DomainClientPage buildDomainClientPage(PageRequest pageRequest,Page<Client> pageRepository) {
		DomainClientPage myDomainPage = new DomainClientPage();
		myDomainPage.setPageNumber(pageRequest.getPageNumber());
		myDomainPage.setPageElements(convertPageRepositoryToDTO(pageRepository));
		myDomainPage.setNumberOfPages(pageRepository.getTotalPages());
		return myDomainPage;
	}

	/**
	 * Convierte un cliente DTO a uno client de repositorio
	 * @param client
	 * @return
	 */
	private Client convertClientDTOToRepository(ClientDTO client) {

		Client myClient = new Client(client.getName(), client.getSurName(),
				client.getAdress(), client.getDni(), client.getPhone(),
				client.getCel(), client.getEmail());
		return myClient;
	}

	/**
	 * Retorna un DTO a partir de un cliente de repositorio
	 * 
	 * @param repositoryClient
	 * @return
	 */
	private ClientDTO convertClientRepositoryToDto(Client repositoryClient) {

		ClientDTO myClientDTO = new ClientDTO(Integer.toString(repositoryClient.getId()),repositoryClient.getName(),
				repositoryClient.getSurName(), repositoryClient.getAdress(),
				repositoryClient.getDni(), repositoryClient.getPhone(),
				repositoryClient.getCel(), repositoryClient.getEmail());

		return myClientDTO;
	}

	private List<ClientDTO> convertPageRepositoryToDTO(Page<Client> page) {	
		
		List<ClientDTO> listClients = new ArrayList<ClientDTO>();
		Iterator<Client> itClient = page.getContent().iterator();		
		while(itClient.hasNext()){			
			listClients.add(convertClientRepositoryToDto(itClient.next()));				
		}		
		return listClients;
	}
	
	private DomainClientPage getDomainClientPage(PageRequest pageRequest) {		
		
		Page<Client> pageRepository = clientRepostitory.findAll(pageRequest);			
		DomainClientPage myDomainPage = buildDomainClientPage(pageRequest,pageRepository);
		
		return myDomainPage;		
	}
	
	
	private DomainClientPage getDomainClientPageByNameOrSurName(String nameOrSurname, PageRequest myPageRequest) {
		
		Page<Client> pageRepository = clientRepostitory.findByNameOrSurName(myPageRequest, nameOrSurname);			
		DomainClientPage myDomainPage = buildDomainClientPage(myPageRequest,pageRepository);		
		return myDomainPage;
	}

	/**
	 * Servicio para eliminar el cliente segun el ID
	 */
	public void deleteById(int idCliente) {
		
		Client myClient =clientRepostitory.findById(idCliente);
		
		System.out.println("El id del cliente es: " + myClient.getName());
		clientRepostitory.delete(clientRepostitory.findById(idCliente));		
	}	
}
