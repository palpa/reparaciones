package com.amp.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.amp.entities.Client;
import com.amp.repository.client.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/app-config.xml")
@Transactional
public class ClientRepositoryTest {
	
	private static String NAME = "CLIENT_NAME";
	private static String SURNAME = "CLIENT_SURNAME";
	private static String ADRESS = "CLIENT_ADRESS";
	private static String DNI = "CLIENT_DNI";
	private static String PHONE = "CLIENT_PHONE";
	private static String CEL = "CLIENT_CEL";
	private static String EMAIL = "CLIENT_EMAIL";
	
	@Autowired
	ClientRepository clientRepository;
	Client myClient;

	private Client client1;
	private Client client2;
	
	@Before
	public void setUp() {
		
		//Creamos el cliente
		client1 = new Client();
		client2 = new Client();
		
		//Inicializamos los valores
		client1.setName(ClientRepositoryTest.NAME);
		client1.setSurName(ClientRepositoryTest.SURNAME);
		client1.setAdress(ClientRepositoryTest.ADRESS);
		client1.setDni(ClientRepositoryTest.PHONE);
		client1.setCel(ClientRepositoryTest.CEL);
		client1.setEmail(ClientRepositoryTest.EMAIL);
		
		client2.setName(ClientRepositoryTest.NAME);
		client2.setSurName(ClientRepositoryTest.SURNAME);
		client2.setAdress(ClientRepositoryTest.ADRESS);
		client2.setDni(ClientRepositoryTest.PHONE);
		client2.setCel(ClientRepositoryTest.CEL);
		client2.setEmail(ClientRepositoryTest.EMAIL);
	}

	@Test
	public void testFindAll() {
		
		//Guardamos los clientes
		clientRepository.save(client1);
		clientRepository.save(client2);
		
		//Recuperamos los clientes
		List<Client> clients = clientRepository.findAll();
		
		assertEquals(clients.size(), 2);
	}
	
	@Test 
	public void testFindAllPageable(){
		
		//Guardamos los clientes
		clientRepository.save(client1);
		clientRepository.save(client2);
		
		//Recupero la pagina de clientes
		PageRequest pageable = new PageRequest(0, 2);
		Page<Client> page = clientRepository.findAll(pageable);		
		
		
		assertEquals(page.getNumberOfElements(), 2);
		
	}
	
	@Test
	public void testFindByNameOrSurname(){
		
		clientRepository.save(client1);
		
		PageRequest pageable = new PageRequest(0, 2);
		Page<Client> myPage1 = clientRepository.findByNameOrSurName(pageable, client1.getName());
		
		Page<Client> myPage2 = clientRepository.findByNameOrSurName(pageable, client1.getSurName());
		
		assertNotNull(myPage1);
		assertEquals(client1.getName(), myPage1.getContent().get(0).getName());
		
		assertNotNull(myPage2);
		assertEquals(client1.getName(), myPage2.getContent().get(0).getName());
	}

}
