package com.amp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.amp.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}

