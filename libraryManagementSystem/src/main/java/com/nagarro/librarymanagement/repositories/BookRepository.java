package com.nagarro.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nagarro.librarymanagement.entities.BooksData;
@Repository

public interface BookRepository extends JpaRepository<BooksData,Integer> {
}
