package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.queue.UserTask;

@RestController
@RequestMapping(value = "/queue")
public class QueueController {

	 @Autowired
	 private UserTask task;
	
	@RequestMapping(value = "/add")
 	public  String addQueue(String context) {
		UserTask task=new UserTask();
		task.addQueue(context);
 		return "succss";
	}
	 
	
}
