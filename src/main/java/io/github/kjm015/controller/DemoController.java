package io.github.kjm015.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.kjm015.manager.DemoManager;

@RestController
public class DemoController {
	
	@Autowired
	private DemoManager manager;
	
	@GetMapping(value = "/", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public String home() {
		return "Welcome to my home page!";
	}
	
	@GetMapping(value = "hello", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public String helloWorld() {
		return "Hello";
	}
	
	@PostMapping(value = "payload", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void sample(@RequestBody String msg) {
		manager.handleHello(msg);
	}

}
