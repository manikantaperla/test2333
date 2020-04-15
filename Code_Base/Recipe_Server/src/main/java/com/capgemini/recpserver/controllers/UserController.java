package com.capgemini.recpserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.recpserver.dao.UserDaoInterface;
import com.capgemini.recpserver.entity.Users;


@RestController
public class UserController {
	
	@Autowired
	private UserDaoInterface userDaoInt;
		
	@PostMapping(value= "/add" ,consumes= {"application/xml","application/json"})
	public String addAlien(@RequestBody Users al) {
		
		userDaoInt.save(al);
		//return "home";
		return "succes";
	}
	
	
	@RequestMapping(value="/fetchall")
	//@ResponseBody
	public List<Users>  fetchAll() {
		
		//System.out.println("method call succes");
		
	return userDaoInt.findAll();
	}
	

}
