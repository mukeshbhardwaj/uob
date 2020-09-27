package com.uob.uobbank.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uob.uobbank.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
