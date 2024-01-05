package com.matheusport.project01.services;






//--(IMPORTS)--//

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.matheusport.project01.entities.User;
import com.matheusport.project01.repositories.AddressRepository;
import com.matheusport.project01.repositories.UserRepository;

import com.matheusport.project01.services.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
//--(END)--//


@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	//FIND-BY-ID
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElseThrow( () -> new ResourceNotFoundException(id));
	}
	
	
	//FIND-ALL
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	//DELETE
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	
	//INSERT
	public User insert(User user ,Long addressId){
		user.setAddress(addressRepository.getReferenceById(addressId));
		user.setAdded(LocalDate.now());
		return userRepository.save(user);
	}
	
	//UPDATE
	public User update(User userNewSetting ,Long id){
		// Reference --> User to set
		User user = userRepository.getReferenceById(id);
		// New setting --> user
		updateData(user, userNewSetting);
		// DB
		return userRepository.save(user);
	}
	
	//Method to auxiliate update
	private void updateData(User user ,User userNewSetting) {
		user.setName(userNewSetting.getName());
	}
	
	//LINK-ADDRESS
	public User updateAddress(Long userId ,Long addressId){
		// Reference --> User to set
		User user = userRepository.getReferenceById(userId);
		user.setAddress(addressRepository.getReferenceById(addressId));
		return userRepository.save(user);
	}
	
	
	
	
	
	
}
