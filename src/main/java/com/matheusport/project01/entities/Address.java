package com.matheusport.project01.entities;

//--(IMPORTS)--//
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//--(END)--//






@Entity
@Table(name = "tb_address")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;

	//--(ATTRIBUTES)--//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String coutry;
	private String cep;
	//--(END)--//
	
	
	
	//--(ASSOCIATION)--//

	// 1 x 1, *   
	@JsonProperty("residents")
	@OneToMany(mappedBy = "address" ,cascade = CascadeType.ALL)
	Set<User> userSet= new HashSet<>();

	//--(END)--
	
	
	//--(CONSTRUCTORS)--//
	
	public Address() {
		
	}

	public Address(Long id, String city, String coutry, String cep) {
		super();
		this.id = id;
		this.city = city;
		this.coutry = coutry;
		this.cep = cep;
	}


	
	//--(END)--//
	
	
	

	//--(GETTERS AND SETTERS)--//
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCoutry() {
		return coutry;
	}

	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Set<User> getUserSet() {
		return userSet;
	}


	
	//--(END)--//
	
	
	
	//--(GETTERS AND SETTERS)--//
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
	
	//--(END)--//
	
}
