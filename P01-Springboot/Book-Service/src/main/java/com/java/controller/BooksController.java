package com.java.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Books;
import com.java.service.BooksService;  
 
@RestController 
@RequestMapping("/java/books")
@CrossOrigin(origins = {"https://hoppscotch.io/"})
public class BooksController   
{   
@Autowired  
BooksService booksService;    
@GetMapping("/book")  
private List<Books> getAllBooks()   
{  
return booksService.getAllBooks();  
}  
@GetMapping("/book/{bookid}")  
private Books getBooks(@PathVariable("bookid") int bookid)   
{  
return booksService.getBooksById(bookid);  
}  
@DeleteMapping("/book/{bookid}")  
private void deleteBook(@PathVariable("bookid") int bookid)   
{  
booksService.delete(bookid);  
}  
@PostMapping("/books")  
private int saveBook(@RequestBody Books books)   
{  
booksService.Update(books);  
return books.getBookid();  
}  
@PutMapping("/books")  
private Books update(@RequestBody Books books)   
{  
booksService.Update(books);  
return books;  
}  
@GetMapping("/block")
public String blockBook(){
    return "Only author can block book";
}

@GetMapping("/search")
public String searchBooks(){
    return "anyone can search book";
}

@GetMapping("/subscribe")
public String subscribeBooks(){
    return "reader can subscribe book";
}

@GetMapping("/unsuscribe")
public String unsuscribeBooks(){
    return "reader can unsubscribe book";
}
}