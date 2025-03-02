package org.lib.LibraryManagement.controller;

import java.util.List;

import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.lib.LibraryManagement.entity.Loan;
import org.lib.LibraryManagement.service.LoanService;
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
@RequestMapping("/Loan")
public class LoanController {
	@Autowired
	private LoanService loanservice;
	
//  save method
	@PostMapping
	public ResponseEntity<ResponseStrcture<Loan>> saveAuthor(@RequestBody Loan loan){
		return loanservice.saveLoan(loan);
	}
// get all aurthor
	
	@GetMapping
	public ResponseEntity<ResponseStrcture<List<Loan>>> All(){
		return loanservice.getAll();
	}
	
//	get aurthor by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Loan>> getbyid(@PathVariable int id){
		return loanservice.getById(id);
	}
	
//  delete aurthor by id
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Loan>> deleteByid(@PathVariable int id){
		return loanservice.deleteloan(id);
	}
	
//	update Aurthor
	@PutMapping
	public ResponseEntity<ResponseStrcture<Loan>> putAuthor(@RequestBody Loan loan){
		return loanservice.saveLoan(loan);
	}

}
