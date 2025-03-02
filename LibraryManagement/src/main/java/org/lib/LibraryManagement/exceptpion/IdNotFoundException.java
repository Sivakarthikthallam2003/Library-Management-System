package org.lib.LibraryManagement.exceptpion;

public class IdNotFoundException extends RuntimeException  {
	
	@Override
	public String getMessage() {
		return "id not avaliable in db";
		
	}
	


}
