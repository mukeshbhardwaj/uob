package com.user.userservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.userservice.model.User;
import com.user.userservice.repo.UserDao;
import com.user.userservice.repo.UserRepo;
import com.user.userservice.service.UserService;

@Service
public class UserServiceImpl implements /* UserDetailsService, */ UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserDao userDao;

//	@Autowired
//	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}

//	// authantication uses
//	@Override
//	public User save(User user) {
//		User newUser = new User();
//		newUser.setEmail(user.getEmail());
//		newUser.setfName(user.getfName());
//		newUser.setId(user.getId());
//		newUser.setlName(user.getlName());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setPhone(user.getPhone());
//		newUser.setUserName(user.getUserName());
//		return userDao.save(newUser);
//	}
//
//	public List<User> findAll() {
//		List<User> list = new ArrayList<>();
//		userDao.findAll().iterator().forEachRemaining(list::add);
//		return list;
//	}
//
//	@Override
//	public void delete(long id) {
//		userDao.deleteById(id);
//	}
//
////	@Override
////	public User findOne(String username) {
////		return userDao.findByUsername(username);
////	}
//
//	@Override
//	public User findById(long id) {
//		Optional<User> optionalUser = userDao.findById( id);
//		return optionalUser.isPresent() ? optionalUser.get() : null;
//	}
//
//	@Override
//	public User update(User userDto) {
//		User user = findById(userDto.getId());
//		if (user != null) {
//			BeanUtils.copyProperties(userDto, user, "password");
//			userDao.save(user);
//		}
//		return userDto;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
