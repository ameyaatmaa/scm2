package com.scm.scm2.repositories;

import com.scm.scm2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String > {

    //db related methods

}
