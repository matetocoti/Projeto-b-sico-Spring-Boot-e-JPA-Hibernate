package com.matheusport.project01.services;






//--(IMPORTS)--//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusport.project01.entities.User;
import com.matheusport.project01.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
//--(END)--//


@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository; 
	
	
	
	
	//FIND-BY-ID
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.get();
	}
	
	
	//FIND-ALL
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	//DELETE
	public void deleteById(Long id) {
		User user = findById(id);
		userRepository.deleteById(user.getId());
	}
	
	
	
}
