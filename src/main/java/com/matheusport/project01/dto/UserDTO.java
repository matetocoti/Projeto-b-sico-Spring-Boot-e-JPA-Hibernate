package com.matheusport.project01.dto;



//--(IMPORTS)--//

import com.matheusport.project01.entities.User;

//--(END)--//


public class UserDTO {

	//--(ATTRIBUTES)--//
		
	private Long id;
	private String name;

	//--(END)--//
	
	
	//--(CONSTRUCTORS)--//
	
	public UserDTO() {
		
	}
	
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
	}



	//--(END)--//
	
	
	//--(GETTERS AND SETTERS)--//
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	//--(END)--//
}
