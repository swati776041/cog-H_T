package com.java.bookservice.Bookservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.bookservice.Bookservices.bean.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


	
	

}
