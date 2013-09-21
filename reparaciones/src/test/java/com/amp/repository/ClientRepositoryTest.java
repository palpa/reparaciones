package com.amp.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.amp.domain.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/app-config.xml")
@Transactional
public class ClientRepositoryTest {

	@Autowired
	ClientRepository clientRepository;

	private Client client;
	
	@Before
	public void setUp() {
		client = new  Client(1, "Jose");
		clientRepository.saveAndFlush(client);
	}

	@Test
	public void testFindById() {
		Client client = clientRepository.findOne(this.client.getId());
		assertEquals(this.client.getName(), client.getName());
	}

}
