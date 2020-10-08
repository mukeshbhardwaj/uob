package com.user.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.userservice.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
