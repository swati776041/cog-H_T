package com.java.bookservice.Bookservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.bookservice.Bookservices.bean.Book;
import com.java.bookservice.Bookservices.exception.Bookserviceexceptions;
import com.java.bookservice.Bookservices.service.AuthorService;


@RestController
@RequestMapping("api/v1/books/")
public class AuthorController {
	@Autowired
	private AuthorService authService;
	@GetMapping("/{bookId}/books")
	public Book getBook(@PathVariable int bookId) {
		return authService.getBookByid(bookId);
	}
	
	@PostMapping("/{authorid}/books")
	public Book createBook(@PathVariable int authorid, @RequestBody Book book) {
		return authService.save(authorid, book);
	}
	@PutMapping("/{authorid}/book/{bookId}/")
	public ResponseEntity<Book> editBook(@PathVariable int authorid, @PathVariable int bookid, @RequestBody Book book){
Book editBook = authService.editBook(authorid, bookid, book);
if(editBook != null) {
	return new ResponseEntity<Book>(editBook, HttpStatus.OK);
	}
return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/{authorid}/book/{bookId}/block=yes")
	public ResponseEntity<?> blockBook(@PathVariable int authorid, @PathVariable int bookId){
Book book1 = authService.blockBook(authorid, bookId);
if(book1 != null) {
	return new ResponseEntity<>( HttpStatus.OK);
	}
return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/{authorid}/book/{bookId}/block=no")
public ResponseEntity<?> unblockBook(@PathVariable int authorid, @PathVariable int bookId) throws Bookserviceexceptions	{
Book book1 = authService.blockBook(authorid, bookId);
if(book1 != null) {
	return new ResponseEntity<>( HttpStatus.OK);
	}
return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
