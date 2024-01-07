package com.matheusport.project01.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.matheusport.project01.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	@Query(value = "SELECT * FROM TB_ADDRESS A WHERE CEP = :cep" ,nativeQuery = true)
	List<Address> findByCep(@Param(value = "cep") String cep);
	
	
}
