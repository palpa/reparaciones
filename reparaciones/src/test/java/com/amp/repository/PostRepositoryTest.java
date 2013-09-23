package com.amp.repository;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amp.repository.PostRepository;
import com.apm.entities.Post;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/app-config.xml")
public class PostRepositoryTest {

	@Autowired
	PostRepository repository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("UN TITULO");
		
		repository.save(post);
		
		Post dbPost = repository.findOne(post.getPostId());
		
		assertNotNull(dbPost);
		
		System.out.println("el titulo es" + dbPost.getTitle());
	}

}
