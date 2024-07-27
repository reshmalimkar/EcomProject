package com.tronSoftech.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tronSoftech.model.User;
import com.tronSoftech.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 */
	public User saveData(User user) {
//		user.setCreatedOn(new Date());
		user.setCreatedOn(LocalDate.now());
		User save = userRepository.save(user);
		return save;
	}
	
	public Optional<User> login(String username,String password){
		Optional<User> opt = userRepository.findByUsername(username);
		if(opt.isPresent()&&opt.get().getPassword().equals(password)) {
			return opt;
		}
		return Optional.empty();
	}

}
