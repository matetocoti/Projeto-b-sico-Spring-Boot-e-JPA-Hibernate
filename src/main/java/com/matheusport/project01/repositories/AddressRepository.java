package com.matheusport.project01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusport.project01.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
