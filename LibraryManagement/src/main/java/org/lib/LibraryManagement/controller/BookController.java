package org.lib.LibraryManagement.controller;

import java.util.List;

import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.lib.LibraryManagement.entity.Book;
import org.lib.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Book")
public class BookController {
	@Autowired
	private BookService bookservice;
	
//  save method
	@PostMapping
	public ResponseEntity<ResponseStrcture<Book>> saveBook(@RequestBody Book book){
		return bookservice.saveBook(book);
	}
// get all aurthor
	
	@GetMapping
	public ResponseEntity<ResponseStrcture<List<Book>>> All(){
		return bookservice.getAll();
	}
	
//	get aurthor by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Book>> getbyid(@PathVariable int id){
		return bookservice.getById(id);
	}
//	get by genre
	@GetMapping("/Books/{Genre}")
	public ResponseEntity<ResponseStrcture<List<Book>>> FindByGenre(@PathVariable String Genre){
		return bookservice.FindByGenre(Genre);
	}
//  delete book by id
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Book>> deleteByid(@PathVariable int id){
		return bookservice.deleteauthor(id);
	}
	
//	update Aurthor
	@PutMapping
	public ResponseEntity<ResponseStrcture<Book>> udateBook(@RequestBody Book book){
		return bookservice.saveBook(book);
	}
//	@GetMapping("/BOOKS/{Name}")
//	public ResponseEntity<ResponseStrcture<List<Book>>> getbyname(@PathVariable String Name){
//		return bookservice.getByName(Name);
//	}

}
