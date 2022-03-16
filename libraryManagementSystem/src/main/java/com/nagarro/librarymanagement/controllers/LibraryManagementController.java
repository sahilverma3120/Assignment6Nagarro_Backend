package com.nagarro.librarymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.librarymanagement.entities.BooksData;
import com.nagarro.librarymanagement.services.BookService;

@RestController
@RequestMapping("/librarymanagement/v1")

public class LibraryManagementController {

	@Autowired
	BookService bookservice;
	
	@PostMapping("/addbook/{bookcode}")
	public BooksData addingBook(@RequestBody BooksData booksdata,@PathVariable("bookcode") int bookcode) {
		return bookservice.saveBook(booksdata,bookcode);
		
	}
	@GetMapping("/books")
	public List<BooksData> findingBook(){
		System.out.println("inside get"); 
		List<BooksData> books = bookservice.findBook();
		return books;
	
	}
	@DeleteMapping("/delete/{bookcode}")
	public void deletingBook(@PathVariable int bookcode) {
		bookservice.deleteBook(bookcode);
	}
	@PutMapping("/update/{bookcode}")
	public BooksData updatingBook(@RequestBody BooksData booksdata,@PathVariable("bookcode") int bookcode) {
		
		return bookservice.updateBook(booksdata,bookcode);
	}
}
