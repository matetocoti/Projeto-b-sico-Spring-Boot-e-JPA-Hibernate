package com.matheusport.project01.repositories;


//--(IMPORTS)--//

import org.springframework.data.jpa.repository.JpaRepository;
import com.matheusport.project01.entities.User;


//--(END)--//


public interface UserRepository extends JpaRepository<User, Long> {

}
