package com.TheNative.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheNative.restservices.entinties.User;
import com.TheNative.restservices.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository  userRepository;
	
	//getAllUser method
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//createUser method 	
   public User createUser(User user) {
	   return userRepository.save(user);
   }
   
   //getUserById method
   public Optional<User> getUserById(Long id) {
	   Optional<User> user = userRepository.findById(id);
	   return user;
   }
   
   //deleteUserById method
   public void deleteUserById(Long id) {
	   if(userRepository.findById(id).isPresent()) {
		   userRepository.deleteById(id);
	   }
   }
   
   //getUserByUsername
   public User getUserByUsername(String username) {
	   return userRepository.findByUsername(username);
   }

}
