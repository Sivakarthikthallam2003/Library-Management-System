package org.lib.LibraryManagement.controller;

import java.util.List;

import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.lib.LibraryManagement.entity.Aurthor;
import org.lib.LibraryManagement.service.AurthorService;
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
@RequestMapping("/aurthor")

public class AurthorController {
	@Autowired
	private AurthorService authorservice;
	
//  save method
	@PostMapping
	public ResponseEntity<ResponseStrcture<Aurthor>> saveAuthor(@RequestBody Aurthor aut){
		return authorservice.saveAurth(aut);
	}
// get all aurthor
	
	@GetMapping
	public ResponseEntity<ResponseStrcture<List<Aurthor>>> All(){
		return authorservice.getAll();
	}
	
//	get aurthor by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Aurthor>> getbyid(@PathVariable int id){
		return authorservice.getById(id);
	}
	
//  delete aurthor by id
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Aurthor>> deleteByid(@PathVariable int id){
		return authorservice.deleteauthor(id);
	}
	
//	update Aurthor
	@PutMapping
	public ResponseEntity<ResponseStrcture<Aurthor>> putAuthor(@RequestBody Aurthor aut){
		return authorservice.saveAurth(aut);
	}
//	@GetMapping("/usingname/{Name}")
//	public ResponseEntity<ResponseStrcture<List<Aurthor>>> getbyname(@PathVariable String Name){
//		return authorservice.getByName(Name);
//	}
}
