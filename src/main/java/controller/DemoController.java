package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manager.DemoManager;

@RestController
public class DemoController {
	
	@Autowired
	private DemoManager manager;
	
	@GetMapping(path = "/hello", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String helloWorld() {
		return "Hello";
	}
	
	@PostMapping(path = "/payload", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void sample(@RequestBody String msg) {
		manager.handleHello(msg);
	}
	

}