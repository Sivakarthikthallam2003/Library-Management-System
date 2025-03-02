package org.lib.LibraryManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.lib.LibraryManagement.entity.Aurthor;
import org.lib.LibraryManagement.repository.AurthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AurthorDao {
	@Autowired
	private AurthorRepository aurthorRepository;
	
//	save aurthor
	public Aurthor saveaur(Aurthor aurthor) {
		return aurthorRepository.save(aurthor);
	}
	
// find all authors
	public List<Aurthor> getAll(){
		return aurthorRepository.findAll();
	}
	
// find by id
	public Optional<Aurthor> findByID(int id){
		return aurthorRepository.findById(id);
	}
//  update aurthor
	public Aurthor update(Aurthor aurthor) {
		return aurthorRepository.save(aurthor);
	}	
	
// Delete by id
	public void delete(Aurthor author) {
		aurthorRepository.delete(author);
		
	}
//	public String  deleteBYId(int id){
//		Optional<Aurthor> ar=aurthorRepository.findById(id);
//		if(ar!=null) {
//			aurthorRepository.delete(ar.get());
//			return "deleted Aurthor";
//		}
//		return "IdIsNotPresented";
//	}v
//	
	

// find by Name
//	public List<Aurthor> findbynames(String name){
//		return aurthorRepository.findByName(name);
//	}
//// findByidANDName
//	public Aurthor findUsingIdAndName(int id,String name) {
//		return aurthorRepository.findByIdAndName(id, name);
//		
//	}

}
