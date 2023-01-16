package com.digitalbooks.userService.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalbooks.userService.entity.Book;


@FeignClient(value="books", url = "http://localhost:8090/api/v1/digitalbooks/")
@CrossOrigin
public interface BookClient {
	 @GetMapping("search")
	    public List<Book> searchBooks(@RequestParam String title, @RequestParam String category,
				@RequestParam Double price, @RequestParam int authorId);
	 
	 
	 @PostMapping("author/{authorid}/book")
		public Book createBook(@PathVariable int authorid, @RequestBody Book book);
	 
	 @PutMapping("author/{authorid}/book/{bookId}/")
		public ResponseEntity<Book> editBook(@PathVariable int authorid, @PathVariable int bookId, @RequestBody Book book);
	 
	 @PostMapping("author/{authorid}/book/{bookId}/blockyes")
		public ResponseEntity<?> blockBook(@PathVariable int authorid, @PathVariable int bookId) ;
	 
	 @PostMapping("author/{authorid}/book/{bookId}/blockno")
		public ResponseEntity<?> unblockBook(@PathVariable int authorid, @PathVariable int bookId);

	 @GetMapping("book/books/{bookId}")
	 public Book getBookById(@PathVariable int bookId);

	 @GetMapping("book/{title}")
	public Book getBookbyTitle(@PathVariable String title);

	 @GetMapping("book/author/{authorId}")
	public List<Book> getBookbyAuthorId(@PathVariable int authorId);

	 @DeleteMapping("author/{authorid}/book/delete/{bookId}/")
	public  ResponseEntity<?> deleteBook(@PathVariable int authorid,@PathVariable int bookId);

@GetMapping("books")
	public List<Book> getBooks();


}
