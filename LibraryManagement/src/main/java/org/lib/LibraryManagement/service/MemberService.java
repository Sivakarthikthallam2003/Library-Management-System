package org.lib.LibraryManagement.service;

import java.util.List;
import java.util.Optional;
import org.lib.LibraryManagement.Dao.MemberDao;
import org.lib.LibraryManagement.Dto.ResponseStrcture;

import org.lib.LibraryManagement.entity.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	// save aurthor
	public ResponseEntity<ResponseStrcture<Member>> saveMember(Member member){
		Member receivedaurthor = memberDao.saveMem(member);
		ResponseStrcture<Member> st=new ResponseStrcture<Member>();
		st.setStatusCode(HttpStatus.CREATED.value());
		st.setMessage("succes");
		st.setData(receivedaurthor);
		return new ResponseEntity<ResponseStrcture<Member>>(st,HttpStatus.CREATED);
	}
	// get aurthor
	public ResponseEntity<ResponseStrcture<List<Member>>> getAll(){
		List<Member> receivedData = memberDao.getAll();
		ResponseStrcture<List<Member>> strcture=new ResponseStrcture<List<Member>>();
		strcture.setStatusCode(HttpStatus.OK.value());
		strcture.setMessage("succes");
		strcture.setData(receivedData);
		return new ResponseEntity<ResponseStrcture<List<Member>>>(strcture,HttpStatus.OK);
	}
	//get by id
	public ResponseEntity<ResponseStrcture<Member>> getById(int id){
		Optional<Member> receivedData = memberDao.findByID(id);
		ResponseStrcture<Member> strcture=new ResponseStrcture<Member>();
		if(receivedData.isPresent()) {
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedData.get());
			return new ResponseEntity<ResponseStrcture<Member>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("member id not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Member>>(strcture,HttpStatus.NOT_FOUND);
	
		}
	}
	// delete by id
	public ResponseEntity<ResponseStrcture<Member>> deleteauthor(int id){
		Optional<Member> receivedData = memberDao.findByID(id);
		ResponseStrcture<Member> strcture=new ResponseStrcture<Member>();
		if(receivedData.isPresent()) {
			Member member=receivedData.get();
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedData.get());
			memberDao.delete(member);
			return new ResponseEntity<ResponseStrcture<Member>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("id not in database");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Member>>(strcture,HttpStatus.NOT_FOUND);

		}	
	}
	// update
	public ResponseEntity<ResponseStrcture<Member>> updateAurthor(Member member){
		Member receivedmember = memberDao.update(member);
		ResponseStrcture<Member> st=new ResponseStrcture<Member>();
		st.setStatusCode(HttpStatus.CREATED.value());
		st.setMessage("succes");
		st.setData(receivedmember);
		return new ResponseEntity<ResponseStrcture<Member>>(st,HttpStatus.CREATED);
	}
}
