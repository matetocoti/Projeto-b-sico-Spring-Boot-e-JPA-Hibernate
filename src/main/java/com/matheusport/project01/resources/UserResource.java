package com.matheusport.project01.resources;







//--(IMPORTS)--//

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusport.project01.entities.User;
import com.matheusport.project01.services.UserService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

//--(END)--//


@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	
	
	//FIND-BY-ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	
	//FIND-ALL
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> userList = userService.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	//DELETE
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	//INSERT
	@PostMapping(value = "/{addressId}")
	public ResponseEntity<User> insert(@RequestBody User user ,@PathVariable Long addressId){
		user = userService.insert(user ,addressId);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	
	
	//UPDATE
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@RequestBody User user ,@PathVariable Long id){
		user = userService.update(user, id);
		return ResponseEntity.ok().body(user);
	} 
	
	//UPDATE-ADDRESS
	@PutMapping(value = "/{userId}/{addressId}")
	public ResponseEntity<User> updateAddress(@PathVariable Long userId ,@PathVariable Long addressId){
		User user = userService.updateAddress(userId, addressId);
		return ResponseEntity.ok().body(user);
	}
	
	
	
	
	
}
