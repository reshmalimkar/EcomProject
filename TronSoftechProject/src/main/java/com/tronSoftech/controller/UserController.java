package com.tronSoftech.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tronSoftech.model.User;
import com.tronSoftech.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "save")
	public User userData(@RequestBody User user) {
		User saveData = userService.saveData(user);
		return saveData;
	}
	
	@PostMapping(value = "login")
	public String doLogin(@RequestBody User user) {
		Optional<User> loginopt = userService.login(user.getUsername(), user.getPassword());
		if(loginopt.isPresent()) {
			return "Login successful for user:" + loginopt.get().getUsername();
		}else {
		return "Invalid username or password";
		}
	}

}
