package com.amp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amp.commons.DomainClientPage;
import com.amp.domain.ClientDTO;
import com.amp.repository.ClientRepository;
import com.apm.entities.Client;

/**
 * @author juan.eduardo.mendoza
 *
 */
/**
 * @author juan.eduardo.mendoza
 *
 */
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

	public ClientDTO getClientById(int id) {
		return convertClientRepositoryToDto(clientRepostitory.findOne(id));
	}
	
	public DomainClientPage getPageClients(int numPage){
		
		//TODO: Hay que tomar el numero de paginas de un archivo de propiedades
		PageRequest myPageRequest = new PageRequest(numPage - 1,10);				
		DomainClientPage myDomainPage = buildDomainClientPage(myPageRequest);		
		return myDomainPage;
	}

	private DomainClientPage buildDomainClientPage(PageRequest pageRequest) {		
		
		Page<Client> pageRepository = clientRepostitory.findAll(pageRequest);	
		
		DomainClientPage myDomainPage = new DomainClientPage();
		myDomainPage.setPageNumber(pageRequest.getPageNumber());		
		myDomainPage.setPageElements(convertPageRepositoryToDTO(pageRepository));
		myDomainPage.setNumberOfPages(pageRepository.getTotalPages());
		
		return myDomainPage;
		
	}

	private List<ClientDTO> convertPageRepositoryToDTO(Page<Client> page) {	
		
		List<ClientDTO> listClients = new ArrayList<ClientDTO>();
		Iterator<Client> itClient = page.getContent().iterator();		
		while(itClient.hasNext()){			
			listClients.add(convertClientRepositoryToDto(itClient.next()));				
		}		
		return listClients;
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
	
	
	public void delete(ClientDTO aClient) {

		clientRepostitory.delete(this.convertClientDTOToRepository(aClient));

	}
}
