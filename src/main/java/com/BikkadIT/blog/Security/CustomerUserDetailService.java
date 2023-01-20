package com.BikkadIT.blog.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BikkadIT.blog.entities.User;
import com.BikkadIT.blog.execeptions.ResourceNotFoundException;
import com.BikkadIT.blog.repositories.UserRepo;
@Service
public class CustomerUserDetailService implements UserDetailsService{

	    @Autowired
		private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
		//		loding username from database by username
//	User user =	this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "email :" +username,0));
	User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "email", username));
		
		return user;
	}// auntication by dadabase

}
