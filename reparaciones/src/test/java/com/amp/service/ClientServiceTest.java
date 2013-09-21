package com.amp.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

import com.amp.domain.Client;
import com.amp.repository.PostRepository;
import com.amp.service.ClientService;
import com.amp.service.ClientServiceImpl;

public class ClientServiceTest {
	private PostRepository clientRepostitory;
	private ClientService clientService;

	/*@Before
	public void doSetup() {
		clientRepostitory = mock(PostRepository.class);
		clientService = new ClientServiceImpl(clientRepostitory);
	}

	@Test
	public void testGetClients() {
		when(userDao.save(any(User.class))).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = (User) invocation.getArguments()[0];
				user.setId(1L);
				return user;
			}
		});

		assertNull(signupForm.getId());

		signupForm = sampleService.saveFrom(signupForm);

		assertNotNull(signupForm.getId());
		assertTrue(signupForm.getId() > 0);
	}*/
}
