package com.user.userservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.user.userservice.model.User;

public interface UserDao extends CrudRepository<User, Long> {

//    User findByUsername(String username);
}
