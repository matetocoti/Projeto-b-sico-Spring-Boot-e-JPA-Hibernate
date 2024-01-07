package com.matheusport.project01.resources;







//--(IMPORTS)--//


import java.util.List;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusport.project01.entities.Address;

import com.matheusport.project01.services.AddressService;
//--(END)--//


@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService addressService;
	
	
	//FIND-BY-ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id){
		Address address = addressService.findById(id);
		return ResponseEntity.ok().body(address);
	}
	
	
	//FIND-ALL
	@GetMapping
	public ResponseEntity<List<Address>> findAll(){
		List<Address> addressList = addressService.findAll();
		return ResponseEntity.ok().body(addressList);
	}
	
	
	//FIND-BY-CEP
	@RequestMapping(value = "/findByCep" ,method = RequestMethod.GET)
	public ResponseEntity<List<Address>> findByCep(@RequestParam(value = "cep" ,defaultValue = "") String cep){
		return ResponseEntity.ok().body(addressService.findByCep(cep));
	}
	
	

	//INSERT
	@PostMapping
	public ResponseEntity<Address> insert(@RequestBody Address address){
		addressService.insert(address);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();
		return ResponseEntity.created(uri).body(address);
	}
	
	
	//UPDATE
	@PutMapping(value = "/{id}")
	public ResponseEntity<Address> update(@RequestBody Address address ,@PathVariable Long id){
	    address = addressService.update(address, id);
		return ResponseEntity.ok().body(address);
	}
	
	
	
	
}
