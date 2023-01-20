package com.BikkadIT.blog.execeptions;
import lombok.Getter;
import lombok.Setter;
@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	
	String fieldName;
	
	long fieldValue;
//	only for string jwt start31 lecture 25:17 min  CustomerUserDetailService blog
	String resourceName2;
	
	String fieldName2;

	 String username;
	 
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFoundException(String resourceName2, String fieldName2, String username) {
		super(String.format("%s not found with %s : %s",resourceName2,fieldName2,username));
		this.resourceName2 = resourceName2;
		this.fieldName2 = fieldName2;
		this.username = username;
	}

}
