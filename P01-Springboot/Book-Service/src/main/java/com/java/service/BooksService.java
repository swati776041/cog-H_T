package com.java.service;  
 
import java.util.ArrayList;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Books;
import com.java.repository.BooksRepository;  

@Service  

public class BooksService   
{  
	
@Autowired
private BooksRepository booksRepository;  
 
public List<Books> getAllBooks()   
{  
List<Books> books = new ArrayList<Books>();  
booksRepository.findAll().forEach(books1 -> books.add(books1));  
return books;  
}   
public Books getBooksById(int id)   
{  
return booksRepository.findById(id).get();  
}  
public void Update(Books books)   
{  
booksRepository.save(books);  
}  
public void delete(int id)   
{  
booksRepository.deleteById(id);  
}   
public void update(Books books, int bookid)   
{  
booksRepository.save(books);  
}
public Books saveBooks(Books books) {
	
	return booksRepository.save(books);
}  
}  
