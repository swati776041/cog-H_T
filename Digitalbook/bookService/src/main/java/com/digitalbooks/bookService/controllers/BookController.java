package com.digitalbooks.bookService.controllers;

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

import com.digitalbooks.bookService.entity.Book;
import com.digitalbooks.bookService.entity.ResponseMessage;
import com.digitalbooks.bookService.exception.BookException;
import com.digitalbooks.bookService.services.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("search")
	public List<Book> searchBook(@RequestParam String title, @RequestParam String category,
			@RequestParam Double price, @RequestParam int authorId){
		List<Book> books = bookService.searchBook(title, category, price, authorId);
		return books;
	}
	@GetMapping("books")
	public List<Book> getBooks(){
		List<Book> books = bookService.searchallBook();
		return books;
	}
	
	@GetMapping("book/books/{bookId}")
	 public Book getBookById(@PathVariable int bookId) throws BookException{
		Book book = bookService.getBookbyId(bookId);
		return book;
	}
	
	@GetMapping("book/{title}")
	 public Book getBookByTitle(@PathVariable String title) throws BookException{
		return bookService.getBookbyTitle(title);
		 
	}
	
	@GetMapping("book/author/{authorId}")
	 public List<Book> getBookbyAUthorId(@PathVariable int authorId) throws BookException{
		return bookService.getBookbyAuthorId(authorId);
		 
	}
	
	
	@PostMapping("author/{authorid}/book")
	public Book createBook(@PathVariable int authorid, @RequestBody Book book) throws BookException {
		
		return bookService.saveBook(authorid,book) ;
		
	}
	
	@PutMapping("author/{authorid}/book/{bookId}/")
	public ResponseEntity<Book> editBook(@PathVariable int authorid, @PathVariable int bookId, @RequestBody Book book)  throws BookException{
		
	Book editBook =  bookService.editBook(authorid,bookId, book) ;
		if (editBook != null) {
			return new ResponseEntity<Book>(editBook, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("author/{authorid}/book/delete/{bookId}/")
	public ResponseEntity<?> deleteBook(@PathVariable int authorid, @PathVariable int bookId)  throws BookException{
			bookService.deleteBook(authorid,bookId);
			 return new ResponseEntity<ResponseMessage>(new ResponseMessage("Book is Deleted"), HttpStatus.OK);
	}
	
	@PostMapping("author/{authorid}/book/{bookId}/blockyes")
	public ResponseEntity<?> blockBook(@PathVariable int authorid, @PathVariable int bookId) throws BookException {
		
	Book book1 =  bookService.blockBook(authorid,bookId) ;
		if (book1 != null) {
			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Book is Blocked"), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("author/{authorid}/book/{bookId}/blockno")
	public ResponseEntity<?> unblockBook(@PathVariable int authorid, @PathVariable int bookId) throws BookException {
		
	Book book1 =  bookService.unblockBook(authorid,bookId) ;
		if (book1 != null) {
			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Book is unblocked"), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
}
