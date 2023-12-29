package com.matheusport.project01.services;




//--(IMPORTS)--//
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.matheusport.project01.entities.Address;
import com.matheusport.project01.repositories.AddressRepository;
import java.util.List;
import java.util.Optional;
//--(END)--//


@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	
	//FIND-BY-ID
	public Address findById(Long id) {
		Optional<Address> optionalAddress = addressRepository.findById(id);
		return optionalAddress.get();
	}
	
	
	//FIND-ALL
	public List<Address> findAll(){
		return addressRepository.findAll();
	}
	
	
	//INSERT
	public Address insert(Address address) {
		return addressRepository.save(address);
	}
	
	
	//UPDATE
	public Address update(Address addressNewSetting ,Long id) {
		Address address = findById(id);
		updateData(addressNewSetting, address);
		return addressRepository.save(address);
	}
	//update Auxiliate
	private void updateData(Address addressNewSetting ,Address address){
		address.setCity(addressNewSetting.getCity());
		address.setCoutry(addressNewSetting.getCoutry());
		address.setCep(addressNewSetting.getCep());
	}
	
	
	
	
	
}
