package com.java.bookservice.Bookservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bookservice.Bookservices.BookservicesApplication;
import com.java.bookservice.Bookservices.bean.Book;
import com.java.bookservice.Bookservices.exception.Bookserviceexceptions;
import com.java.bookservice.Bookservices.repository.BookRepository;



	@Service
	public class AuthorService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book save(int authorid, Book book) {
		return bookRepo.save(book);
	}
	public Book editBook(int authorid, int bookId, Book book)
	{
		Optional<Book> originalBook = bookRepo.findById(bookId);
		if(originalBook.isPresent()) {
		originalBook.get().setActive(book.getActive());
		originalBook.get().setCategory(book.getCategory());
		originalBook.get().setContent(book.getContent());
		originalBook.get().setPrice(book.getPrice());
		originalBook.get().setPublishDate(book.getPublishDate());
		originalBook.get().setPublisher(book.getPublisher());
		originalBook.get().setTitle(book.getTitle());
		return bookRepo.save(originalBook.get());
		}
		return null;
	}
	public Book blockBook(int authorid, int bookId)
	{
		Optional<Book> originalBook = bookRepo.findById(bookId);
		if(originalBook.isPresent()) {
		originalBook.get().setActive(false);
		return bookRepo.save(originalBook.get());
		}
		return null;
	}
	public Book unblockBook(int authorid, int bookId) throws Bookserviceexceptions
	{
		Optional<Book> originalBook = bookRepo.findById(bookId);
		if(originalBook.isPresent()) {
		originalBook.get().setActive(true);
		return bookRepo.save(originalBook.get());
		}
		else
		{
			throw new Bookserviceexceptions("book not found");
		}
		
	}
	
	public Book getBookByid(int bookid) {
		Optional<Book> originalBook = bookRepo.findById(bookid);
		if(originalBook.isPresent()) {
			originalBook.get();
			return originalBook.get();
			}
		return null;
	}
		


	}

