package com.binay.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestOAuthController {
	
	@GetMapping(path = "/hello/{name}")
	public String printHello(@PathVariable String name ) {
		
		return "Hello " + name;
	}
	
	@GetMapping(path = "/admin/{name}")
	public String printHelloAdmin(@PathVariable String name ) {
		
		return "Hello Admin " + name;
	}


}
