package com.digitalbooks.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.userService.entity.Book;
import com.digitalbooks.userService.restclient.BookClient;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/digitalbook/")
@SecurityRequirement(name = "demo_security_scheme")
@CrossOrigin
public class AuthorController {
	
	@Autowired
 private BookClient bookClient;

	@PostMapping("author/{authorid}/book")
	public Book createBook(@PathVariable int authorid, @RequestBody Book book) {
		return bookClient.createBook(authorid, book);
	}
	
	@PutMapping("author/{authorid}/book/{bookId}/")
	public ResponseEntity<Book> editBook(@PathVariable int authorid, @PathVariable int bookId, @RequestBody Book book) {
		return bookClient.editBook(authorid, bookId, book);
	}
	
	@DeleteMapping("author/{authorid}/book/delete/{bookId}/")
	public ResponseEntity<?> deleteBook(@PathVariable int authorid, @PathVariable int bookId)  {
			return bookClient.deleteBook(authorid,bookId);
	}
	
	@PostMapping("author/{authorid}/book/{bookId}/blockyes")
	public ResponseEntity<?> blockBook(@PathVariable int authorid, @PathVariable int bookId) {
		return bookClient.blockBook(authorid, bookId);
	}
	
	@PostMapping("author/{authorid}/book/{bookId}/blockno")
	public ResponseEntity<?> unblockBook(@PathVariable int authorid, @PathVariable int bookId) {
		return bookClient.unblockBook(authorid, bookId);
	}
}
