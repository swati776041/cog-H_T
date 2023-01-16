package com.java.bookservice.Bookservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.java.bookservice.Bookservices.repository.BookRepository;
import com.java.bookservice.Bookservices.service.BookService;

@SpringBootTest
public class Bookservicetest {

	@MockBean
	private BookRepository bookrepo;
	@Autowired
	private BookService service;
	
//	@Test
//	public void shouldPlaceOrder() throws BookException, SQLException {
//		System.out.println(service);
//		Book book = new Book();
//		
//		Mockito
//			.when(bookrepo.saveBook(book))
//			.thenReturn(new Book(1, "vgt", "t", "65", "3/4/4", "hy", "gt", false, "huy", false));
//		
//		
//		Assertions.assertEquals(expectedResult,actualResult);
//	
//	}
}
