package org.lib.LibraryManagement.exceptpion;

import org.lib.LibraryManagement.Dto.ResponseStrcture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class GlobalException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStrcture<String>> handleIdNotFoundException(IdNotFoundException exception){
		ResponseStrcture<String> st=new ResponseStrcture<String>();
		st.setStatusCode(HttpStatus.NOT_FOUND.value());
		st.setMessage("not_found");
		st.setData(exception.getMessage());
		return new ResponseEntity<ResponseStrcture<String>> (st,HttpStatus.NOT_FOUND);
		
	}


}
