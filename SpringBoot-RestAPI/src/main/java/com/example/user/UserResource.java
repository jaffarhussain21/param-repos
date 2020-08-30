package com.example.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		 User user = userDaoService.findOne(id);
		 if(user == null) {
			 throw new UserNotFoundException("This user not found !!! "+id);
		 }
		 
		 return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = userDaoService.save(user);
		java.net.URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(saveUser.getId()).toUri();

		return ResponseEntity.created(url).build();
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		userDaoService.delete(id);
	}
}
