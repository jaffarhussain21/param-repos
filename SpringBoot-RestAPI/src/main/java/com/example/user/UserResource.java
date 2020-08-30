package com.example.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userDaoService;

	@GetMapping("/getUsers")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/getUsers/{id}")
	public User retieveUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		userDaoService.save(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		userDaoService.delete(id);
	}
}
