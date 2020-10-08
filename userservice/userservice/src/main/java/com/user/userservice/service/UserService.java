package com.user.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.userservice.model.User;

@Service
public interface UserService {

	void addUser(User user);
	
//	//authantication uses
//	User save(User user);
//	
//	List<User> findAll();
//	
//    void delete(long id);
//
////    User findOne(String username);
//
//    User findById(long id);
//
//    User update(User user);

}
