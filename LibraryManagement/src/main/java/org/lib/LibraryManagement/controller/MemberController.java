package org.lib.LibraryManagement.controller;

import java.util.List;

import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.lib.LibraryManagement.entity.Member;
import org.lib.LibraryManagement.service.MemberService;
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
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
//  save method
	@PostMapping
	public ResponseEntity<ResponseStrcture<Member>> saveAuthor(@RequestBody Member member){
		return memberService.saveMember(member);
	}
// get all Member
	@GetMapping
	public ResponseEntity<ResponseStrcture<List<Member>>> All(){
		return memberService.getAll();
	}
	
//	get memeber by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Member>> getbyid(@PathVariable int id){
		return memberService.getById(id);
	}
	
//  delete memeber by id
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStrcture<Member>> deleteByid(@PathVariable int id){
		return memberService.deleteauthor(id);
	}
	
//	update member
	@PutMapping
	public ResponseEntity<ResponseStrcture<Member>> putAuthor(@RequestBody Member member){
		return memberService.saveMember(member);
	}


}
