package com.digitalbooks.bookService.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.bookService.entity.Book;
import com.digitalbooks.bookService.exception.BookException;
import com.digitalbooks.bookService.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public Book getBookbyId(int bookId) throws BookException {
		Book book=bookRepo.findById(bookId).get();
		if(book != null && !book.equals(""))
			return book;
		else throw new BookException("Book wtih book id " + bookId + " not found");
	}
	
	public List<Book> searchBook(String title, String category, Double price, int authorId){
		List<Book> books = bookRepo.findByTitleIgnoreCaseOrCategoryOrPriceOrAuthorId(title, category, price,authorId)
				.stream().filter(book -> book.getActive() == true).collect(Collectors.toList());
		return books;
		
	}
	
	public Book saveBook(int authorId, Book book) throws  BookException{
		List<Book> books = bookRepo.findByAuthorId(authorId);
		for(Book b: books) {
			if(b.getTitle().equals(book.getTitle()))
				throw new  BookException("Book already Present");
		}
		return bookRepo.save(book);
	}

	public Book editBook(int authorid, int bookId, Book book)   throws BookException{

		Optional<Book> originalBook =bookRepo.findById(bookId);
		if(originalBook.isPresent() && (authorid == originalBook.get().getAuthorId())) {
			if(originalBook.get().getActive() != book.getActive())
			originalBook.get().setActive(book.getActive());
			
			if(originalBook.get().getCategory() != book.getCategory())
			originalBook.get().setCategory(book.getCategory());
			
			if(originalBook.get().getContent() != book.getContent())
			originalBook.get().setContent(book.getContent());
			
			if(originalBook.get().getPrice() != book.getPrice())
			originalBook.get().setPrice(book.getPrice());
			
			if(originalBook.get().getPublishDate() != book.getPublishDate())
			originalBook.get().setPublishDate(book.getPublishDate());
			
			if(originalBook.get().getPublisher() != book.getPublisher())
			originalBook.get().setPublisher(book.getPublisher());
			
			if(originalBook.get().getTitle() != book.getTitle())
			originalBook.get().setTitle(book.getTitle());
			return bookRepo.save(originalBook.get());
		}
		else throw new BookException("Book with book id " + bookId + " not found");
	
	}
	
	public int deleteBook (int authorId, int bookId) throws  BookException{
		Optional<Book> originalBook =bookRepo.findById(bookId);
		if(originalBook.isPresent() && originalBook.get().getAuthorId() == authorId){
		 bookRepo.deleteById(authorId);
		 return bookId;
		}
		else throw new BookException("Book with book id " + bookId + " not found");
		
	}

	public Book blockBook(int authorid, int bookId) throws BookException {
		Optional<Book> originalBook =bookRepo.findById(bookId);
		if(originalBook.isPresent()) {
			originalBook.get().setActive(false);
			return bookRepo.save(originalBook.get());
		}
		else throw new BookException("Book wtih book id " + bookId + " not found");
	}

	public Book unblockBook(int authorid, int bookId)  throws BookException {
		Optional<Book> originalBook =bookRepo.findById(bookId);
		if(originalBook.isPresent()) {
			originalBook.get().setActive(true);
			return bookRepo.save(originalBook.get());
		}
		else throw new BookException("Book with book id " + bookId + " not found");
	}

	public Book getBookbyTitle(String title) throws BookException {
		Book book = bookRepo.findByTitle(title);
		if(book != null && !book.equals(""))
		return book;
		else  throw new BookException("Book with Title  " +title+ " not found");
	}
	
	public List<Book> getBookbyAuthorId(int authorId) throws BookException {
		List<Book> books =bookRepo.findByAuthorId(authorId);
		if(books!=null || !books.isEmpty())
			return books;
		else  throw new BookException("Book with Author id " +authorId+ " not found");
	}

	public List<Book> searchallBook() {
		List<Book> books =bookRepo.findAll();
		return books;
	}

}
