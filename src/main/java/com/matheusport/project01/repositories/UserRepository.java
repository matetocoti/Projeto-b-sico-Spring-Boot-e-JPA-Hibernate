package com.matheusport.project01.repositories;




//--(IMPORTS)--//

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.matheusport.project01.entities.User;


//--(END)--//


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);
	
	
	@Query(value = "SELECT * FROM TB_USER WHERE LOWER(TB_USER.NAME) = Lower(:name)" ,nativeQuery = true)
	List<User> findByUserName(@Param("name") String name);
}
