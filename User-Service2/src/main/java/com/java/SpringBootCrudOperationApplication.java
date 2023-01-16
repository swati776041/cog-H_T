package com.java;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.model.Books;
import com.java.service.BooksService;
@SpringBootApplication
public class SpringBootCrudOperationApplication implements CommandLineRunner
{
	@Autowired
	private BooksService service;

	@Override
	public void run(String... args) throws Exception {
		service.saveBooks(new Books(1, "Alice in the wonderland","Lewis Carroll", 200));
		service.saveBooks(new Books(2, "An american tragedy", "Deresier",160));
		service.saveBooks(new Books(3,"Area of Darkness","naipaul", 300));
		service.saveBooks(new Books(4,"Arms and the man","shaw",100));
	}
public static void main(String[] args)
{
SpringApplication.run(SpringBootCrudOperationApplication.class, args);
}
}
