package com.example.restapi.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.HelloWorldBean;

@RestController
public class BookRestController {

	@GetMapping("/books")
	public HelloWorldBean getBooks() {		
		return new HelloWorldBean("HelloWorldBean");
	}
	
	@GetMapping("/books-path-variable/{name}")
	public HelloWorldBean getBooksPathVariable(@PathVariable String name) {		
		return new HelloWorldBean(String.format("HelloWorldBean, %s", name));
	}
}
