package com.lg.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping("/where")
	public String am() {
		
		return "Hello from Gallery File running at port: " + env.getProperty("local.server.port");
	}
}
