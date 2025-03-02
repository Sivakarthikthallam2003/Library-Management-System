package org.lib.LibraryManagement.repository;

import java.util.List;

import org.lib.LibraryManagement.entity.Aurthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AurthorRepository extends JpaRepository<Aurthor, Integer>{
	
//	Aurthor findByIdAndName(int id,String name);
//	
//	List<Aurthor> findByName(String name);
	

}
