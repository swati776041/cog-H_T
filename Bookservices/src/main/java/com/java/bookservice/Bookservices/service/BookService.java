package com.java.bookservice.Bookservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bookservice.Bookservices.bean.Book;
import com.java.bookservice.Bookservices.repository.BookRepository;



@Service
public class BookService {
	@Autowired
private BookRepository bookRepo;
public List<Book> getallBooks()
{
	List<Book> book= new ArrayList<>();
	bookRepo.findAll().forEach(book::add);
	return book;
}
public void addBook(Book book) {
	bookRepo.save(book);
	
}
public void updateBook(Integer id, Book book) {
	bookRepo.save(book);
	
}
public void deleteBook(Integer id) {
	bookRepo.deleteById(id);
	
}
public void saveBook(Book book) {
	bookRepo.save(book);
	
}

public List<Book> getBookData(String bookid) {
	// TODO Auto-generated method stub
	return null;
}
 
}
