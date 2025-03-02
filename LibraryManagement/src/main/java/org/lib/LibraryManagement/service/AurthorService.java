package org.lib.LibraryManagement.service;

import java.util.List;
import java.util.Optional;

import org.lib.LibraryManagement.Dao.AurthorDao;
import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.lib.LibraryManagement.entity.Aurthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AurthorService {
	@Autowired
	private AurthorDao authorDao;
	// save aurthor
	public ResponseEntity<ResponseStrcture<Aurthor>> saveAurth(Aurthor  aurthor){
		Aurthor receivedaurthor = authorDao.saveaur(aurthor);
		ResponseStrcture<Aurthor> st=new ResponseStrcture<Aurthor>();
		st.setStatusCode(HttpStatus.CREATED.value());
		st.setMessage("succes");
		st.setData(receivedaurthor);
		return new ResponseEntity<ResponseStrcture<Aurthor>>(st,HttpStatus.CREATED);
	}
	// get aurthor
	public ResponseEntity<ResponseStrcture<List<Aurthor>>> getAll(){
		List<Aurthor> receivedData = authorDao.getAll();
		ResponseStrcture<List<Aurthor>> strcture=new ResponseStrcture<List<Aurthor>>();
		strcture.setStatusCode(HttpStatus.OK.value());
		strcture.setMessage("succes");
		strcture.setData(receivedData);
		return new ResponseEntity<ResponseStrcture<List<Aurthor>>>(strcture,HttpStatus.OK);
	}
	//get by id
	public ResponseEntity<ResponseStrcture<Aurthor>> getById(int id){
		Optional<Aurthor> receivedData = authorDao.findByID(id);
		ResponseStrcture<Aurthor> strcture=new ResponseStrcture<Aurthor>();
		if(receivedData.isPresent()) {
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("succes");
			strcture.setData(receivedData.get());
			return new ResponseEntity<ResponseStrcture<Aurthor>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("id not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Aurthor>>(strcture,HttpStatus.NOT_FOUND);			
		}
		
	}
	// delete by id
	public ResponseEntity<ResponseStrcture<Aurthor>> deleteauthor(int id){
		Optional<Aurthor> receivedData = authorDao.findByID(id);
		ResponseStrcture<Aurthor> strcture=new ResponseStrcture<Aurthor>();
		if(receivedData.isPresent()) {
			Aurthor author=receivedData.get();
			strcture.setStatusCode(HttpStatus.OK.value());
			strcture.setMessage("deleted");
			strcture.setData(receivedData.get());
			authorDao.delete(author);
			return new ResponseEntity<ResponseStrcture<Aurthor>>(strcture,HttpStatus.OK);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("id not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Aurthor>>(strcture,HttpStatus.NOT_FOUND);

		}	
	}
//	public ResponseEntity<ResponseStrcture<String>> deleteauthor(int id){
//		String receivedData = authorDao.deleteBYId(id);
//		ResponseStrcture<String> strcture=new ResponseStrcture<String>();
//		if(receivedData== "deleted Aurthor") {
//			strcture.setStatusCode(HttpStatus.OK.value());
//			strcture.setMessage("succes");
//			strcture.setData(receivedData);
//			return new ResponseEntity<ResponseStrcture<String>>(strcture,HttpStatus.OK);
//		}
//		else {
//			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
//			strcture.setMessage("Id not found");
//			strcture.setData(null);
//			return new ResponseEntity<ResponseStrcture<String>>(strcture,HttpStatus.NOT_FOUND);	
//		}
//	}
	// update
	public ResponseEntity<ResponseStrcture<Aurthor>> updateAurthor(Aurthor  aurthor){
		Aurthor receivedaurthor = authorDao.update(aurthor);
		ResponseStrcture<Aurthor> strcture=new ResponseStrcture<Aurthor>();
		if(receivedaurthor!=null) {
			strcture.setStatusCode(HttpStatus.CREATED.value());
			strcture.setMessage("succes");
			strcture.setData(receivedaurthor);
			return new ResponseEntity<ResponseStrcture<Aurthor>>(strcture,HttpStatus.CREATED);
		}
		else {
			strcture.setStatusCode(HttpStatus.NOT_FOUND.value());
			strcture.setMessage("id not found");
			strcture.setData(null);
			return new ResponseEntity<ResponseStrcture<Aurthor>>(strcture,HttpStatus.NOT_FOUND);
			
		}
		
	}
	//find byname
//	public ResponseEntity<ResponseStrcture<List<Aurthor>>> getByName(String name){
//		List<Aurthor> receivedData = authorDao.findbynames(name);
//		ResponseStrcture<List<Aurthor>> strcture=new ResponseStrcture<List<Aurthor>>();
//		strcture.setStatusCode(HttpStatus.OK.value());
//		strcture.setMessage("succes");
//		strcture.setData(receivedData);
//		return new ResponseEntity<ResponseStrcture<List<Aurthor>>>(strcture,HttpStatus.OK);
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
