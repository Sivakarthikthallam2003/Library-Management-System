package org.lib.LibraryManagement.service;

import java.util.List;
import java.util.Optional;
import org.lib.LibraryManagement.Dao.AurthorDao;
import org.lib.LibraryManagement.Dao.BookDao;
import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.lib.LibraryManagement.entity.Aurthor;
import org.lib.LibraryManagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AurthorDao authorDao;
	
	// save aurthor
	public ResponseEntity<ResponseStrcture<Book>> saveBook(Book  book){
		Book receivedBook = bookDao.savebook(book);
		int aid=receivedBook.getAurthor().getId();
		Optional<Aurthor> aurthor=authorDao.findByID(aid);
		ResponseStrcture<Book> strcture=new ResponseStrcture<Book>();
		if(aurthor.isPresent()) {
			receivedBook.setAurthor(aurthor.get());
			strcture.setStatusCode(HttpStatus.CREATED.value());
			strcture.setMessage("succes");
			strcture.setData(receivedBook);
			return new ResponseEntity<ResponseStrcture<Book>>(strcture,HttpStatus.CREATED);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("Aurthor id not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Book>>(strcture,HttpStatus.NOT_FOUND);

			
		}
					
	}
			
	// get all aurthor
	public ResponseEntity<ResponseStrcture<List<Book>>> getAll(){
		List<Book> receivedBook = bookDao.getAll();
		ResponseStrcture<List<Book>> strcture=new ResponseStrcture<List<Book>>();
		strcture.setStatusCode(HttpStatus.OK.value());
		strcture.setMessage("succes");
		strcture.setData(receivedBook);
		return new ResponseEntity<ResponseStrcture<List<Book>>>(strcture,HttpStatus.OK);
	}
	//get by id
	public ResponseEntity<ResponseStrcture<Book>> getById(int id){
		Optional<Book> receivedBook = bookDao.findByID(id);
		ResponseStrcture<Book> strcture=new ResponseStrcture<Book>();
		if(receivedBook.isPresent()) {
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedBook.get());
			return new ResponseEntity<ResponseStrcture<Book>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("data not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Book>>(strcture,HttpStatus.NOT_FOUND);				
		}
	}
	
	//	get by genre
	public ResponseEntity<ResponseStrcture<List<Book>>> FindByGenre(String GENRE){
		List<Book> receivedBook = bookDao.FindByGenre(GENRE);
		ResponseStrcture<List<Book>> strcture=new ResponseStrcture<List<Book>>();
		if(receivedBook.isEmpty()) {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("genre not Found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<List<Book>>>(strcture,HttpStatus.NOT_FOUND);	
		}
		else {
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedBook);
			return new ResponseEntity<ResponseStrcture<List<Book>>>(strcture,HttpStatus.OK);
		}
	}
	
	// delete by id
	public ResponseEntity<ResponseStrcture<Book>> deleteauthor(int id){
		Optional<Book> receivedData = bookDao.findByID(id);
		ResponseStrcture<Book> strcture=new ResponseStrcture<Book>();
		if(receivedData.isPresent()) {
			Book book=receivedData.get();
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedData.get());
			bookDao.delete(book);
			return new ResponseEntity<ResponseStrcture<Book>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("data not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Book>>(strcture,HttpStatus.NOT_FOUND);			
		}	
	}
	// update
	public ResponseEntity<ResponseStrcture<Book>> updateBook(Book  book){
		Book receivedBook = bookDao.update(book);
		ResponseStrcture<Book> st=new ResponseStrcture<Book>();
		st.setStatusCode(HttpStatus.CREATED.value());
		st.setMessage("succes");
		st.setData(receivedBook);
		return new ResponseEntity<ResponseStrcture<Book>>(st,HttpStatus.CREATED);
	}


	
//	//find byname
//	public ResponseEntity<ResponseStrcture<List<Book>>> getByName(String name){
//		List<Book> receivedBook = bookDao.findbynames(name);
//		ResponseStrcture<List<Book>> strcture=new ResponseStrcture<List<Book>>();
//		strcture.setStatusCode(HttpStatus.OK.value());
//		strcture.setMessage("succes");
//		strcture.setData(receivedBook);
//		return new ResponseEntity<ResponseStrcture<List<Book>>>(strcture,HttpStatus.OK);
//	}
	//get by id and NAME
//		public ResponseEntity<ResponseStrcture<Aurthor>> getByIdAndName(int id,String Name){
//			Optional<Aurthor> receivedData = authorDao.findUsingIdAndName(id,Name);
//			ResponseStrcture<Aurthor> strcture=new ResponseStrcture<Aurthor>();
//			strcture.setStatusCode(HttpStatus.OK.value());
//			strcture.setMessage("succes");
//			strcture.setData(receivedData.get());
//			return new ResponseEntity<ResponseStrcture<Aurthor>>(strcture,HttpStatus.OK);
//		}

}
