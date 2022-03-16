package com.nagarro.librarymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.librarymanagement.entities.UserData;
import com.nagarro.librarymanagement.model.User;
import com.nagarro.librarymanagement.services.UserService;

@RestController
@RequestMapping("/librarymanagement/v1")
public class UserManagementController {
	@Autowired
	UserService userservice;
	
	@GetMapping("/users/{userid}")
	public 
	// ResponseEntity<User>
	List<User> authenticateUsers(@PathVariable String userid ){
		System.out.println(userid);
		List<User> users= userservice.findUserbyId(userid);
	    return users;
		//	return new ResponseEntity<User>(users.get(0), HttpStatus.OK);
		
	}

}
