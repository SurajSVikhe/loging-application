package com.BikkadIT.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.BikkadIT.blog.entities.Category;
import com.BikkadIT.blog.entities.Comment;
import com.BikkadIT.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private UserDto user;
	
	private CategoryDto category;
	
	private Set<CommentDto> comments=new HashSet<>();//when we phase comment automatically its comments will seen
	
}
