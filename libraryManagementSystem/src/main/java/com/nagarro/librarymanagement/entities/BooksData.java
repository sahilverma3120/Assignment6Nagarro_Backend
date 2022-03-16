package com.nagarro.librarymanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BooksData {
	@Id
	private int  bookcode;
	private String bookname;
	private String author;
	private String adddate;
	public int getBookcode() {
		return bookcode;
	}
	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}
	public String getBookName() {
		return bookname;
	}
	public void setBookName(String bookName) {
		this.bookname = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAddDate() {
		return adddate;
	}
	public void setAddDate(String addDate) {
		this.adddate = addDate;
	}
	@Override
	public String toString() {
		return "BooksData [bookCode=" + bookcode + ", bookName=" + bookname + ", author=" + author + ", addDate="
				+ adddate + "]";
	}
	
	

}
