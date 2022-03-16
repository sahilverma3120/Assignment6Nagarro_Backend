package com.nagarro.advancejava.webpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.advancejava.webpro.entity.Library;

public interface LibraryDao extends JpaRepository<Library, Integer> {
	
	 

}
