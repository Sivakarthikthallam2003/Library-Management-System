package org.lib.LibraryManagement.Dao;

import java.util.List;
import java.util.Optional;
import org.lib.LibraryManagement.entity.Book;
import org.lib.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private BookRepository bookRepository;
	
//	save book
	public Book savebook(Book book) {
		return bookRepository.save(book);
	}
	
// get all book
	public List<Book> getAll(){
		return bookRepository.findAll();
	}
	
// find by id
	public Optional<Book> findByID(int id){
		return bookRepository.findById(id);
	}
//	BOOK BY GENRE
	public List<Book> FindByGenre(String genre){
		return bookRepository.findByGenere(genre);
	}
	
// Delete by id
	// Delete by id
		public void delete(Book book) {
			bookRepository.delete(book);
			
		}
//  update Book
	public Book update(Book book) {
		return bookRepository.save(book);
	}	
	
//// find by Name
//	public List<Book> findbynames(String name){
//		return bookRepository.findByName(name);
//	}
	
// findByidANDName
//	public Book findUsingIdAndName(int id,String name) {
//		return bookRepository.findByIdAndName(id, name);
//		
//	}

}

