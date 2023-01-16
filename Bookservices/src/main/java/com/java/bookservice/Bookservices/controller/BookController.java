package com.java.bookservice.Bookservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bookservice.Bookservices.bean.Book;
import com.java.bookservice.Bookservices.service.BookService;


@RestController
public class BookController {
	@Autowired
	private BookService bookservice;
	@RequestMapping("/Books")
public List<Book> getallBooks(){
	
	return  bookservice.getallBooks();
}
	@GetMapping("/Books/{bookId}")
	public List<Book> getBookDetails(@PathVariable String bookId){
		String bookid= bookId;
		List<Book> response= new ArrayList<Book>();
		Book mybook = new Book();
		List<Book> booklist=bookservice.getBookData(bookid);
		for(Book book:booklist) {
			mybook.setId(book.getId());	
			mybook.setTitle(book.getTitle());
			mybook.setCategory(book.getCategory());
			mybook.setPrice(book.getPrice());
			mybook.setPublishDate(book.getPublishDate());
			mybook.setPublisher(book.getPublisher());
			mybook.setImage(book.getImage());
			mybook.setContent(book.getContent());
			mybook.setActive(book.getActive());
			mybook.setSubscribed(book.getSubscribed());
			response.add(mybook);
			}
		return response;
		
	}
	@RequestMapping(method = RequestMethod.POST, value="/Books")
public void addBook(@RequestBody Book book) {
		bookservice.addBook(book);
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Books/{id}")
	public void updateBook(@PathVariable Integer id, @RequestBody Book book) {
			bookservice.updateBook(id, book);
		}
	public void deleteBook(@PathVariable Integer id ) {
		bookservice.deleteBook(id);
	}
	}

