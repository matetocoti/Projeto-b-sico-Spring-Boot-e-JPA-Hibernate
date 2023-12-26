package com.matheusport.project01.entities;

//--(IMPORTS)--//
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;


import jakarta.persistence.Table;
import java.io.Serializable;

import java.time.LocalDate;

import java.util.Objects;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//--(END)--//

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	
	//--(ATTRIBUTES)--//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd")
	private LocalDate added;
	//--(END)--//
	
	
	
	//--(ASSOCIATION)--//
	@JsonIgnore
	@ManyToOne
	private Address address;
	//--(END)--//	
		
	
	
	//--(CONSTRUCTORS)--//
	
	public User() {
		super();
	}

	
	public User(Long id, String name ,Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.added = LocalDate.now(); 
	}
	//--(END)--//	

	
	
	
	//--(GETTERS AND SETTERS)--//
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	

	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAdded() {
		return added;
	}

	public void setAdded(LocalDate added) {
		this.added = added;
	}

	
	//--(END)--//
	
	
	//--(HASHCODE AND EQUALS)--//
	
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}






	
	//--(END)--//
}
