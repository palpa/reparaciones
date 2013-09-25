package com.amp.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

import com.amp.domain.Client;
import com.amp.repository.ClientRepository;
import com.amp.service.ClientService;
import com.amp.service.ClientServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ClientServiceTest {
	@Autowired
	private ClientRepository clientRepostitory;
	@Autowired
	private ClientService clientService;

	@Before
	public void setup() {
		Client client = new Client(1, "Jose");

		Mockito.when(clientRepostitory.findOne(1)).thenReturn(client);
	}

	@After
	public void verify() {
		Mockito.verify(clientRepostitory, VerificationModeFactory.times(1))
				.findOne(Mockito.anyInt());
		// This is allowed here: using container injected mocks
		Mockito.reset(clientRepostitory);
	}

	@Test
	public void testGetClients() {
		Client client = clientRepostitory.findOne(1);
		
		assertEquals(1, client.getId());
        assertEquals("Jose", client.getName());
	}

	@Configuration
	static class ClientServiceTestContextConfiguration {

		@Bean
		public ClientService clientService() {
			return new ClientServiceImpl();
		}

		@Bean
		public ClientRepository clientRepository() {
			return Mockito.mock(ClientRepository.class);
		}
	}
}
