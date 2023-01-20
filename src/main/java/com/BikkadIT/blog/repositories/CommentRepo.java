package com.BikkadIT.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

	
}
