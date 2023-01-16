package com.java.repository;
  
import org.springframework.data.jpa.repository.JpaRepository;


import com.java.model.Books;  

public interface BooksRepository extends JpaRepository<Books, Integer> 
{  
}  