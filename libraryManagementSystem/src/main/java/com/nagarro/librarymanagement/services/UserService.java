package com.nagarro.librarymanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.librarymanagement.entities.UserData;
import com.nagarro.librarymanagement.model.User;
import com.nagarro.librarymanagement.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	
	public List<User> findUserbyId(String userid){
		List<User> users = new ArrayList<>();
		
		List<UserData> userdata = userrepo.findByuserid(userid);
		
		for(UserData usersdata : userdata) {
			User user = new User();
			user.setUserid(usersdata.getUserId());
			user.setPassword(usersdata.getPassword());;
			
			users.add(user);
		}
		return users;
		
	}

}
