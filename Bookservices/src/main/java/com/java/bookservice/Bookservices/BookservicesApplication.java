package com.java.bookservice.Bookservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import com.java.bookservice.Bookservices.bean.Book;
import com.java.bookservice.Bookservices.service.BookService;

@SpringBootApplication
public class BookservicesApplication{
//implements CommandLineRunner 
	
	@Autowired
	private BookService service;


	public static void main(String[] args) {
		SpringApplication.run(BookservicesApplication.class, args);
	}

//@Override
//     public void run(String... args) throws Exception {
//	service.saveBook(new Book(1, "frt", "oiu", 234, "yt", "fgy", "yui", false, "hjj", false));
//	service.saveBook(new Book(1, "argy", "b", 150, "d", "23/5/23","e", true, "frtyuug", true));
//	   	service.saveBook(new Book(1, "aabc", "c", 200, "e", "23/5/23","f", true, "frtyuug", true));
//			service.saveBook(new Book(1, "aabc", "d", 300, "f", "23/5/23","g", true, "frtyuug", true));
//		}
}


