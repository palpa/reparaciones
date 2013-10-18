package com.amp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amp.commons.DomainClientPage;
import com.amp.domain.ClientDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/app-config.xml")
public class ClientServiceTest {
	
	@Autowired
	private ClientService clientService;
	private ClientDTO myClient;
	
	private static String CLIENT_NAME ="client_name";
	private static String CLIENT_SURNAME ="client_surname";
	private static String CLIENT_ADRESS ="client_adress";
	private static String CLIENT_PHONE ="client_phone";
	private static String CLIENT_CEL = "client_cel";
	private static String CLIENT_DNI = "client_dni";
	

	@Before
	public void setup() {
		
		myClient = new ClientDTO();
		myClient.setName(ClientServiceTest.CLIENT_NAME);
		myClient.setSurName(ClientServiceTest.CLIENT_SURNAME);
		myClient.setAdress(ClientServiceTest.CLIENT_ADRESS);
		myClient.setPhone(ClientServiceTest.CLIENT_PHONE);
		myClient.setCel(ClientServiceTest.CLIENT_CEL);
		myClient.setDni(ClientServiceTest.CLIENT_DNI);
		
	}
	
	@Test
	public void getPageClientTest(){
		
		clientService.addClient(myClient);
		DomainClientPage page = clientService.getPageClients(0);
		
		assertEquals(page.getPageElements().size(), 1);			
	}
	
	@Test
	public void removeTest(){
		 
//		clientService.addClient(myClient);		
//		//ClientDTO aClient = clientService.getClientById(1);	
//		DomainClientPage page = clientService.getPageClients(1);
//		System.out.println("Tamaño de la pagina: " + page.getPageElements().size());
//		
//		//clientService.delete(aClient);
//		
//		
//		System.out.println("Tamaño de la pagina: " + page.getPageElements().size());
//		
//		assertEquals(page.getNumberOfPages(), 1);	
						
	}

	@Test	
	public void getClientByIDTest(){
		
		clientService.addClient(myClient);		
		ClientDTO aClient = clientService.getClientById(1);
		
		assertEquals(aClient.getName(),ClientServiceTest.CLIENT_NAME);
		assertEquals(aClient.getSurName(), ClientServiceTest.CLIENT_SURNAME);
		assertEquals(aClient.getAdress(),ClientServiceTest.CLIENT_ADRESS);
		assertEquals(aClient.getPhone(),ClientServiceTest.CLIENT_PHONE);
		assertEquals(aClient.getCel(), ClientServiceTest.CLIENT_CEL);
		assertEquals(aClient.getDni(),ClientServiceTest.CLIENT_DNI);
		
		assertNotNull(aClient);
		
		clientService.delete(myClient);
	}

}
