package com.nagarro.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nagarro.librarymanagement.entities.BooksData;
import com.nagarro.librarymanagement.repositories.BookRepository;

@Service
@Component
public class BookService {
	@Autowired
	private BookRepository bookrepo ;
	
	public BooksData saveBook(BooksData books,int bookcode) {
		BooksData newbook = new BooksData();
		newbook.setBookcode(bookcode);
		newbook.setBookName(books.getBookName());
		newbook.setAuthor(books.getAuthor());
		newbook.setAddDate(books.getAddDate());
		return bookrepo.save(newbook);
		
	}
	
	public List<BooksData> findBook(){
		return bookrepo.findAll();
		
	}
	
	public void deleteBook(int bookcode) {
		bookrepo.deleteById(bookcode);
	}
	public BooksData updateBook(BooksData books,int bookcode) {
	    BooksData existingbook=bookrepo.findById(bookcode).orElse(null);
		existingbook.setBookName(books.getBookName());
		existingbook.setAuthor(books.getAuthor());
		existingbook.setAddDate(books.getAddDate());
		existingbook.setBookcode(bookcode);
		
	    return bookrepo.save(existingbook);
	}

}
