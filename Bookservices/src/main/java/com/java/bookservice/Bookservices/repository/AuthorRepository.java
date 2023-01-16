package com.java.bookservice.Bookservices.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.bookservice.Bookservices.bean.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

	

}

