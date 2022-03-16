package com.nagarro.librarymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nagarro.librarymanagement.entities.UserData;
@Repository
public interface UserRepository extends JpaRepository<UserData,Integer> {
	
	public  List<UserData> findByuserid(String userid);

}
