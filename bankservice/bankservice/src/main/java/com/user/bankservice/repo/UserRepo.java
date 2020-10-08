package com.user.bankservice.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.bankservice.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
