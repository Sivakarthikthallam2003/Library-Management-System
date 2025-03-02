package org.lib.LibraryManagement.service;

import java.util.List;
import java.util.Optional;

import org.lib.LibraryManagement.Dao.BookDao;
import org.lib.LibraryManagement.Dao.LoanDao;
import org.lib.LibraryManagement.Dao.MemberDao;
import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.lib.LibraryManagement.entity.Book;
import org.lib.LibraryManagement.entity.Loan;
import org.lib.LibraryManagement.entity.Member;
import org.lib.LibraryManagement.exceptpion.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
public class LoanService {
	@Autowired
	private LoanDao loanDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private MemberDao memberDao;
	
	// save aurthor
	public ResponseEntity<ResponseStrcture<Loan>> saveLoan(Loan  loan){
		Loan receivedloan = loanDao.saveLoan(loan);
		int bid=receivedloan.getBook().getId();
		int mid=receivedloan.getMember().getId();
		Optional<Book> book1=bookDao.findByID(bid);
		Optional<Member> member=memberDao.findByID(mid);
		ResponseStrcture<Loan> strcture=new ResponseStrcture<Loan>();
		if(book1.isPresent()&&member.isPresent()) {
			receivedloan.setBook(book1.get());
			receivedloan.setMember(member.get());
			strcture.setStatusCode(HttpStatus.CREATED.value());
			strcture.setMessage("succes");
			strcture.setData(receivedloan);
			return new ResponseEntity<ResponseStrcture<Loan>>(strcture,HttpStatus.CREATED);

		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("chect the id of book and member");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Loan>>(strcture,HttpStatus.NOT_FOUND);
		}
		
	//	ResponseStrcture<Loan> st=new ResponseStrcture<Loan>();
//		st.setStatusCode(HttpStatus.CREATED.value());
//		st.setMessage("succes");
//		st.setData(receivedloan);
//		return new ResponseEntity<ResponseStrcture<Loan>>(st,HttpStatus.CREATED);
	}
	//get all loan
	public ResponseEntity<ResponseStrcture<List<Loan>>> getAll(){
		List<Loan> receivedData = loanDao.getAll();
		ResponseStrcture<List<Loan>> strcture=new ResponseStrcture<List<Loan>>();
		strcture.setStatusCode(HttpStatus.OK.value());
		strcture.setMessage("succes");
		strcture.setData(receivedData);
		return new ResponseEntity<ResponseStrcture<List<Loan>>>(strcture,HttpStatus.OK);
	}
	
	//get by id
	public ResponseEntity<ResponseStrcture<Loan>> getById(int id){
		Optional<Loan> receivedData = loanDao.findByID(id);
		ResponseStrcture<Loan> strcture=new ResponseStrcture<Loan>();
		if(receivedData.isPresent()) {
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedData.get());
			return new ResponseEntity<ResponseStrcture<Loan>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("loan id not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Loan>>(strcture,HttpStatus.NOT_FOUND);

				
		}
	}
	
	// delete by id
	public ResponseEntity<ResponseStrcture<Loan>> deleteloan(int id){
		Optional<Loan> receivedData = loanDao.findByID(id);
		ResponseStrcture<Loan> strcture=new ResponseStrcture<Loan>();
		if(receivedData.isPresent()) {
			Loan loan=receivedData.get();
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedData.get());
			loanDao.delete(loan);
			return new ResponseEntity<ResponseStrcture<Loan>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("loan id not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Loan>>(strcture,HttpStatus.NOT_FOUND);
		}	
	}
	// update
		public ResponseEntity<ResponseStrcture<Loan>> updateloan(Loan  loan){
			Loan receivedaurthor = loanDao.update(loan);
			ResponseStrcture<Loan> st=new ResponseStrcture<Loan>();
			st.setStatusCode(HttpStatus.CREATED.value());
			st.setMessage("succes");
			st.setData(receivedaurthor);
			return new ResponseEntity<ResponseStrcture<Loan>>(st,HttpStatus.CREATED);
		}
}
