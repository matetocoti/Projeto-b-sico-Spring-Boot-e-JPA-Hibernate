package com.matheusport.project01.config;



//--(IMPORTS)--//

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusport.project01.entities.Address;
import com.matheusport.project01.entities.User;
import com.matheusport.project01.repositories.AddressRepository;
import com.matheusport.project01.repositories.UserRepository;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//--(END)--//



@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	
	//--(REPOSITORIES)--//
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository; 
	//--(END)--//
	
	
	
	
	
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Address address01 = new Address(null ,"AA", "BR", "2222222");
		
		
		addressRepository.save(address01);
		
		
		
		User user01 = new User(null ,"Matheus" ,address01);
		User user02 = new User(null ,"Pedri" ,address01);
		
		
		
		
		
		userRepository.saveAll(Arrays.asList(user01 ,user02));
	}
}
